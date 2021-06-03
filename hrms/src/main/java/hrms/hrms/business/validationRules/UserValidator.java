package hrms.hrms.business.validationRules;

import hrms.hrms.entities.concretes.User;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.business.constants.Messages;
public class UserValidator {
		public Result userCheckFields(User user) {
			String email = user.getEmail();
			String password = user.getPassword();
			
			if ((email == null || email.isBlank()) || (password == null || password.isBlank())) {
				return new ErrorResult(Messages.userFieldsInvalid);
			}
			
			return new SuccessResult();
			
	}
		
		
}
