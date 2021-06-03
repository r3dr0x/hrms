package hrms.hrms.business.validationRules;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.core.utilities.results.ErrorResult;

import org.springframework.stereotype.Component;

import hrms.hrms.business.constants.Messages;

@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService{

	@Override
	public Result employerUserCheckFields(Employer employer) {
		
		String companyName = employer.getCompanyName();
		String webAddress = employer.getWebAddress();
		String phoneNumber = employer.getPhoneNumber();
		
		if (!super.userCheckFields(employer).isSuccess()
                || (companyName == null || companyName.isBlank())
                || (webAddress == null || webAddress.isBlank())
                || (phoneNumber == null || phoneNumber.isBlank()))
        {
            return new ErrorResult(Messages.userFieldsInvalid);
        }
			return new SuccessResult();	
		
		
		
	}

	@Override
	public Result isEmailDomainCheck(Employer employer) {
		String email = employer.getEmail();
		String webAddress = employer.getWebAddress();
		
		String domain = webAddress.split("www.")[1];
		
		if (domain.equals(email.split("@")[1])) {
			return new SuccessResult();
			
			
		}
		return new ErrorResult(Messages.employerEmailInvalid);
	}
		
}
