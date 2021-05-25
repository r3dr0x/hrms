package hrms.hrms.business.concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EmailService;
import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.business.concrete.checkHelper.EmployerCheckHelper;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.core.utilities.results.*;

@Service
public class EmployerManager implements EmployerService{

	
	
	private  EmployerDao employerDao;
	private  EmailService emailService;
	
	
	public EmployerManager(EmployerDao employerDao , EmailService emailService) {
		this.emailService = emailService;
		this.employerDao = employerDao;
	}
	
	
	
	
	
	
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<>(this.employerDao.findAll());
	}

	@Override
	public DataResult<List<Employer>> findByEmailIs(String email) {
		return new SuccessDataResult<>(this.employerDao.findByEmailIs(email));
	}

	@Override
	public Result add(Employer employer) {
		var checkEmail = this.findByEmailIs(employer.getEmail()).getData().size() !=0;
		var checkFields = !EmployerCheckHelper.allFieldsAreRequired(employer);
		
		String errorMessage = "";
		
		if (checkEmail || checkFields) {
			
			if(checkEmail) {
				errorMessage = "Bu E - Posta Sistemde Kayıtlıdır";
			}
			
			if ( checkFields) {
				errorMessage = "Bu Alanlar Sistemde Mevcuttur";
			}
			
			return new ErrorResult(errorMessage);
		}
		this.employerDao.save(employer);
        return new SuccessResult(this.emailService.sendEmail(employer).getMessage());
	}
		
}
