package hrms.hrms.business.abstracts;


import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Education;
import hrms.hrms.entities.dtos.EducationDto;

public interface EducationService {
    DataResult<List<Education>> getAll();
    Result add(EducationDto educationDto);
}
