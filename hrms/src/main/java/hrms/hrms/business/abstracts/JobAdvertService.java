package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.core.utilities.results.Result;

public interface JobAdvertService {
		DataResult<List<JobAdvert>> getAll();
		DataResult<List<JobAdvert>> getByActiveIs();
		DataResult<List<JobAdvert>> getByActiveIsAndEmployer_Id(int employerId);
		
		Result closeJobAdvert(int jobAdvertId);
}
