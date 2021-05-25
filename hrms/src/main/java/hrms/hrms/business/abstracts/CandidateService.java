package hrms.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();

	DataResult<List<Candidate>> findByEmailIs(String email);

	DataResult<List<Candidate>> findByIdentityNumberIs(String identityNumber);
		
	
	  
	
	DataResult<Boolean> checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear);
	
	Result add(Candidate candidate);
}
