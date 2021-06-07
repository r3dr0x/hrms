package hrms.hrms.business.concrete;

import hrms.hrms.business.abstracts.JobExperienceService;
import hrms.hrms.core.utilities.converter.DtoConverterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import hrms.hrms.entities.concretes.JobExperience;
import hrms.hrms.entities.dtos.JobExperienceDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExperienceManager implements JobExperienceService {
	
	
    private final JobExperienceDao jobExperienceDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
        this.jobExperienceDao = jobExperienceDao;
        this.dtoConverterService = dtoConverterService;
    }
	
	
	

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<>(this.jobExperienceDao.findAll(),"Data Listelendi");
	}

    @Override
    public Result add(JobExperienceDto jobExperienceDto) {
        this.jobExperienceDao.save((JobExperience)this.dtoConverterService.dtoToBaseClassConverter(jobExperienceDto, JobExperience.class));
        return new SuccessResult("Added");
    }

}
