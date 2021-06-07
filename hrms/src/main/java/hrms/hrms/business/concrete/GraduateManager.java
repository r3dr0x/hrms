package hrms.hrms.business.concrete;


import hrms.hrms.business.abstracts.GraduateService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.GraduateDao;
import hrms.hrms.entities.concretes.Graduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import hrms.hrms.business.abstracts.GraduateService;

@Service
public class GraduateManager implements GraduateService{

    private final GraduateDao graduateDao;

    @Autowired
    public GraduateManager(GraduateDao graduateDao) {
        this.graduateDao = graduateDao;
    }

	@Override
	public DataResult<List<Graduate>> getAll() {
		 return new SuccessDataResult<>(this.graduateDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Graduate graduate) {
		if (graduateDao.existsByDescription(graduate.getDescription()))  {
			return new ErrorResult("Zaten Mevcut");
			
		}
		
		this.graduateDao.save(graduate);
		return  new SuccessResult("Kaydedildi");
	}
	
	
}
