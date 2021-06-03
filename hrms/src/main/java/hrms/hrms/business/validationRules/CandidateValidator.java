package hrms.hrms.business.validationRules;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import hrms.hrms.business.constants.Messages;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.entities.concretes.Candidate;

@Component
public class CandidateValidator extends UserValidator implements CandidateValidatorService{

	@Override
	public Result candidateUserCheckFields(Candidate candidate) {
		String firstName = candidate.getFirstName();
		String lastName = candidate.getLastName();
		String identityNumber = candidate.getIdentityNumber();
		LocalDate dateOfBirth = candidate.getDateOfBirth();
		
		if (!super.userCheckFields(candidate).isSuccess()
                || (firstName == null || firstName.isBlank())
                || (lastName == null || lastName.isBlank())
                || (identityNumber == null || identityNumber.isBlank() || identityNumber.length() != 11)
                || (dateOfBirth == null || dateOfBirth.toString().isBlank()))
        {
            return new ErrorResult(Messages.userFieldsInvalid);
        }
		return new SuccessResult();
	}
	
		
}
