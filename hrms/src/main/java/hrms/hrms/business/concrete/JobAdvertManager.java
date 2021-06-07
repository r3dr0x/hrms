package hrms.hrms.business.concrete;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.business.constants.Messages;
import hrms.hrms.core.utilities.converter.DtoConverterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	
	private final JobAdvertDao jobAdvertDao;
	private final DtoConverterService dtoConverterService;
	
	
	
	public JobAdvertManager(JobAdvertDao jobAdvertDao, DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.dtoConverterService = dtoConverterService;
	}
	
	
	

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<>(this.jobAdvertDao.findAll(), Messages.jobAdvertsListed);
	}




	@Override
	public DataResult<List<JobAdvert>> getByActiveIs() {
		return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIs(),Messages.jobAdvertsListedByActivationStatus);
	}




	@Override
	public DataResult<List<JobAdvert>> getByActiveIsAndEmployer_Id(int employerId) {
		return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIsAndEmployer_Id(employerId), Messages.jobAdvertsListedByActivationStatusAndByEmployerId);
	}




	@Override
	public Result add(JobAdvertAddDto jobAdvertAddDto) {
		this.jobAdvertDao.save((JobAdvert)this.dtoConverterService.dtoToBaseClassConverter(jobAdvertAddDto, JobAdvert.class));
        return new SuccessResult("Added");
	}




    @Override
    public Result closeJobAdvert(int jobAdvertId) {
        JobAdvert tempJobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
        tempJobAdvert.setActive(false);

        this.jobAdvertDao.save(tempJobAdvert);
        return new SuccessResult(Messages.updateJobAdvertActivationStatusToDeactivate);
    }




    @Override
    public Result openJobAdvert(int jobAdvertId) {
        JobAdvert tempJobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
        tempJobAdvert.setActive(true);

        this.jobAdvertDao.save(tempJobAdvert);
        return new SuccessResult(Messages.updateJobAdvertActivationStatusToActivate);
    }






    
		
}
