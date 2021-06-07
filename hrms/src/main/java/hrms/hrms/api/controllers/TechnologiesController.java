package hrms.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.TechnologyService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Technology;
import hrms.hrms.entities.dtos.TechnologyDto;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	
	
		private final TechnologyService technologyService;

		
		@Autowired
		public TechnologiesController(TechnologyService technologyService) {
			super();
			this.technologyService = technologyService;
		}
		
		
		@GetMapping("/getall")
		public DataResult<List<Technology>> getAll(){
			return this.technologyService.getAll();
			}
		
		
		@PostMapping("/add")
		public Result add(@Valid @RequestBody TechnologyDto technologyDto ) {
			return this.technologyService.add(technologyDto);
		}
		
		
}
