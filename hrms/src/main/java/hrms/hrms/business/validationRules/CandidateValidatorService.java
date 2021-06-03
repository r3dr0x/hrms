package hrms.hrms.business.validationRules;

import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.core.utilities.results.Result;

public interface CandidateValidatorService {
	 Result candidateUserCheckFields(Candidate candidate);
}
