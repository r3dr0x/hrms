package hrms.hrms.business.concrete;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.EmailService;
import hrms.hrms.business.concrete.checkHelper.UserCheckHelper;
import hrms.hrms.business.constants.Messages;
import hrms.hrms.business.validationRules.CandidateValidatorService;
import hrms.hrms.core.adapters.UserCheckService;
import hrms.hrms.core.utilities.business.BusinessEngine;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.CandidateDao;
import hrms.hrms.dataAccess.abstracts.UserDao;
import hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateManager extends UserManager<Candidate> implements CandidateService  {

    private final CandidateDao candidateUserDao;
    private final CandidateValidatorService candidateUserValidatorService;
    private final UserCheckService userCheckService;
    private final EmailService emailService;

    @Autowired
    public CandidateManager(UserDao<Candidate> userDao, CandidateValidatorService candidateUserValidatorService, UserCheckService userCheckService, EmailService emailService) {
        super(userDao);
        this.candidateUserDao = (CandidateDao) userDao;
        this.candidateUserValidatorService = candidateUserValidatorService;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(this.candidateUserDao.findAll(), Messages.usersListed);
    }

    @Override
    public Result add(Candidate candidateUser) {
        List<Result> results = new ArrayList<>();

        results.add(BusinessEngine.run(this.checkUserRealOrNot(candidateUser.getIdentityNumber(), candidateUser.getFirstName(), candidateUser.getLastName(), candidateUser.getDateOfBirth())));
        results.add(BusinessEngine.run(super.existsByEmail(candidateUser.getEmail())));
        results.add(BusinessEngine.run(this.checkIdentityNumber(candidateUser.getIdentityNumber())));
        results.add(BusinessEngine.run(this.candidateUserValidatorService.candidateUserCheckFields(candidateUser)));

        Result result = UserCheckHelper.checkLogicResults(results);

        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }

        this.candidateUserDao.save(candidateUser);
        return new SuccessResult(this.emailService.sendEmail(candidateUser).getMessage());
    }

    public Result checkUserRealOrNot(String identityNumber, String firstName, String lastName, LocalDate dateOfBirthYear) {
        var logic = this.userCheckService.checkIfRealPerson(identityNumber, firstName, lastName, dateOfBirthYear);

        if (!logic){
            return new ErrorResult(Messages.notRealPerson);
        }

        return new SuccessResult(Messages.validationSuccess);
    }

    public Result checkIdentityNumber(String identityNumber) {
        var logic = this.candidateUserDao.existsByIdentityNumber(identityNumber);

        if (logic){
            return new ErrorResult(Messages.identityNumberExist);
        }

        return new SuccessResult(Messages.validationSuccess);
    }
}
