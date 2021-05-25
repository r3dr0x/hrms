package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.core.utilities.results.Result;
public interface EmployerService {
		DataResult<List<Employer>> getAll();
		DataResult<List<Employer>> findByEmailIs(String email);
		
		Result add(Employer employer);
}
