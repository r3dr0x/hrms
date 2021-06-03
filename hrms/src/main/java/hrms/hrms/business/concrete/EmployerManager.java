package hrms.hrms.business.concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EmailService;
import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.business.concrete.checkHelper.UserCheckHelper;
import hrms.hrms.business.constants.Messages;
import hrms.hrms.business.validationRules.EmployerValidatorService;
import hrms.hrms.core.utilities.business.BusinessEngine;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.dataAccess.abstracts.UserDao;
import hrms.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService{

	
	
    private final EmployerDao employerUserDao;
    private final EmployerValidatorService employerUserValidatorService;
    private final EmailService emailService;
	
	
    @Autowired
    public EmployerManager(UserDao<Employer> userDao, EmployerValidatorService employerUserValidatorService, EmailService emailService) {
        super(userDao);
        this.employerUserDao = (EmployerDao) userDao;
        this.employerUserValidatorService = employerUserValidatorService;
        this.emailService = emailService;
    }
	
	
	
	
	
	
	
    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerUserDao.findAll(), Messages.usersListed);
    }
    
    @Override
    public Result add(Employer employerUser) {
    	
    	List<Result> results = new ArrayList<>();
    	
    	results.add(BusinessEngine.run(super.existsByEmail(employerUser.getEmail())));
    	results.add(BusinessEngine.run(this.employerUserValidatorService.employerUserCheckFields(employerUser)));
    	results.add(BusinessEngine.run(this.employerUserValidatorService.isEmailDomainCheck(employerUser)));
    	
    	Result result = UserCheckHelper.checkLogicResults(results);
    	
    	if (!result.isSuccess()) {
    		return new ErrorResult(result.getMessage());
    	}
    	
    	this.employerUserDao.save(employerUser);
    	return new SuccessResult(this.emailService.sendEmail(employerUser).getMessage());
    	
    	
    	
    	
    }

		
}
