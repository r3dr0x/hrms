package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Graduate;

public interface GraduateService {
    DataResult<List<Graduate>> getAll();
    Result add(Graduate graduate);
}
