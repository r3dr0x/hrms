package hrms.hrms.business.abstracts;


import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Language;
import hrms.hrms.entities.dtos.LanguageDto;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();
    Result add(LanguageDto languageDto);
}
