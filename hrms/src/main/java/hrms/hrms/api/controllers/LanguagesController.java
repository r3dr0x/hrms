package hrms.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.LanguageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Language;
import hrms.hrms.entities.dtos.LanguageDto;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
		
	
	private final LanguageService languageService;

	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		
		this.languageService = languageService;
	}
	
	
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getAll() {
		return this.languageService.getAll();
	}
	
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody LanguageDto  languageDto ) {
		return this.languageService.add(languageDto);
	}
	
	
	
}
