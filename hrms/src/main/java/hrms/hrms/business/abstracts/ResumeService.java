package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Resume;
import hrms.hrms.entities.dtos.ResumeAddDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {
    DataResult<List<Resume>> getAll();
    Result add(ResumeAddDto resumeAddDto);

    Result uploadImage(MultipartFile multipartFile, int resumeId);
}