package hrms.hrms.business.concrete;
import hrms.hrms.business.abstracts.TechnologyService;
import hrms.hrms.core.utilities.converter.DtoConverterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.TechnologyDao;
import hrms.hrms.entities.concretes.Technology;
import hrms.hrms.entities.dtos.TechnologyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService{

	
	
    private final TechnologyDao technologyDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
        this.technologyDao = technologyDao;
        this.dtoConverterService = dtoConverterService;
    }
	
	
	
	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<>(this.technologyDao.findAll());
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
        this.technologyDao.save((Technology)this.dtoConverterService.dtoToBaseClassConverter(technologyDto, Technology.class));
        return new SuccessResult("Added");
	}
		
}
