package hrms.hrms.business.concrete;

import java.util.List;

import hrms.hrms.business.abstracts.LanguageService;
import hrms.hrms.core.utilities.converter.DtoConverterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.LanguageDao;
import hrms.hrms.entities.concretes.Language;
import hrms.hrms.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LanguageManager implements LanguageService{

	 	private final LanguageDao languageDao;
	    private final DtoConverterService dtoConverterService;

	    @Autowired
	    public LanguageManager(LanguageDao languageDao, DtoConverterService dtoConverterService) {
	        this.languageDao = languageDao;
	        this.dtoConverterService = dtoConverterService;
	    }
	
	
	
	
	@Override
	public DataResult<List<Language>> getAll() {
		 return new SuccessDataResult<>(this.languageDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(LanguageDto languageDto) {
        this.languageDao.save((Language)this.dtoConverterService.dtoToBaseClassConverter(languageDto, Language.class));
        return new SuccessResult("Eklendi");
	}

}
