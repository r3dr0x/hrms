package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Technology;
import hrms.hrms.entities.dtos.TechnologyDto;

import java.util.List;

public interface TechnologyService {
    DataResult<List<Technology>> getAll();
    Result add(TechnologyDto technologyDto);
}
