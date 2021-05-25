package hrms.hrms.business.concrete;

import org.springframework.stereotype.Component;

import hrms.hrms.business.abstracts.EmailService;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.entities.concretes.User;

@Component
public class EmailManager implements EmailService{

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("E - Posta Başarıyla Gönderildi  : " + user.getEmail());
	}
		 
}
