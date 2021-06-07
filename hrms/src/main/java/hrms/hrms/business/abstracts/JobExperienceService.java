package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobExperience;
import hrms.hrms.entities.dtos.JobExperienceDto;

import java.util.List;

public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();
    Result add(JobExperienceDto jobExperienceDto);
}
