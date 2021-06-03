package hrms.hrms.business.validationRules;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;

public interface EmployerValidatorService {
		Result employerUserCheckFields(Employer employer);
		Result isEmailDomainCheck(Employer employer);
		
}
