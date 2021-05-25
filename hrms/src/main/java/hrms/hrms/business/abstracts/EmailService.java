package hrms.hrms.business.abstracts;


import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.User;


public interface EmailService {
	 Result sendEmail(User user);
		
}
