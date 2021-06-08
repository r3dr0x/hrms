package hrms.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EducationService;
import hrms.hrms.core.utilities.converter.DtoConverterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EducationDao;
import hrms.hrms.entities.concretes.Education;
import hrms.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {
    private final EducationDao educationDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
        this.educationDao = educationDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<>(this.educationDao.findAll(), "Data listed");
    }

    @Override
    public Result add(EducationDto educationDto) {
        this.educationDao.save((Education)this.dtoConverterService.dtoToBaseClassConverter(educationDto, Education.class));
        return new SuccessResult("Added");
    }
}
