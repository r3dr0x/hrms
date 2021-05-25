package hrms.hrms.business.concrete;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.EmailService;
import hrms.hrms.core.adapters.UserCheckService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CandidateDao;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.business.concrete.checkHelper.CandidateCheckHelper;

@Service
public class CandidateManager implements CandidateService{
	
	
    private final CandidateDao candidateDao;
    private final UserCheckService userCheckService;
    private final EmailService emailService;
	
    @Autowired
    public CandidateManager(CandidateDao candidateUserDao, UserCheckService userCheckService, EmailService emailService) {
        this.candidateDao = candidateUserDao;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }
	
	
	
	
	

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(this.candidateDao.findAll());
    }

    @Override
    public DataResult<List<Candidate>> findByEmailIs(String email) {
        return new SuccessDataResult<>(this.candidateDao.findByEmailIs(email));
    }

    @Override
    public DataResult<List<Candidate>> findByIdentityNumberIs(String identityNumber) {
        return new SuccessDataResult<>(this.candidateDao.findByIdentityNumberIs(identityNumber));
    }

    @Override
    public DataResult<Boolean> checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear) {
        return new DataResult<>(this.userCheckService.checkIfRealPerson(nationalityId, firstName, lastName, dateOfBirthYear), true);
    }
	







	@Override
	public Result add(Candidate candidate) {
		var checkEmail = this.findByEmailIs(candidate.getEmail()).getData().size() != 0;
		var checkIdentityNumber = this.findByIdentityNumberIs(candidate.getIdentityNumber()).getData().size() != 0;
		var checkUserRealOrNot = !this.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getDateOfBirth()).getData();
		var checkFields = !CandidateCheckHelper.allFieldsAreRequired(candidate);
		
		if (checkEmail || checkIdentityNumber || checkUserRealOrNot || checkFields) {
			
			String errorMessage = "";
			
			if (checkEmail || checkIdentityNumber ) {
				errorMessage +=  "E - Posta Ya Da Kimlik Numaranız Zaten Mevcut";
				
			}
			if(checkUserRealOrNot) {
				errorMessage += "Bu Kullanıcı Gerçek Değil";
				
			}
			if(checkFields) {
				errorMessage += "Lütfen Tüm Alanları Doldurunuz";
			}
			
			
			return new ErrorResult(errorMessage);
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult(this.emailService.sendEmail(candidate).getMessage());

	}
	
	
	

}
