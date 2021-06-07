package hrms.hrms.business.concrete;
import hrms.hrms.business.abstracts.ResumeService;
import hrms.hrms.core.adapters.cloudinary.CloudinaryService;
import hrms.hrms.core.utilities.converter.DtoConverterService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.ResumeDao;
import hrms.hrms.entities.concretes.Resume;
import hrms.hrms.entities.dtos.ResumeAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ResumeManager implements ResumeService{
		
	private final ResumeDao resumeDao;
    private final CloudinaryService cloudinaryService;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService, DtoConverterService dtoConverterService) {
        this.resumeDao = resumeDao;
        this.cloudinaryService = cloudinaryService;
        this.dtoConverterService = dtoConverterService;
    }

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<>(this.resumeDao.findAll());
	}

    @Override
    public Result add(ResumeAddDto resumeAddDto) {
        this.resumeDao.save((Resume)this.dtoConverterService.dtoToBaseClassConverter(resumeAddDto, Resume.class));
        return new SuccessResult("Added");
    }

    @Override
    public Result uploadImage(MultipartFile multipartFile, int resumeId) {
        try {
            String filePath = this.cloudinaryService.upload(multipartFile).getData().get("url").toString();

            Resume tempResume = resumeDao.getOne(resumeId);
            tempResume.setPhoto(filePath);
            resumeDao.save(tempResume);

            return new SuccessResult("Uploaded");
        } catch (IOException e) {
            return new ErrorResult("Exception: " + e.getMessage());
        }
    }
}