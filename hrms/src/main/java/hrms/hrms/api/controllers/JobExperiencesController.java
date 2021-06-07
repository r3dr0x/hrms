package hrms.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobExperience;
import hrms.hrms.entities.dtos.JobExperienceDto;

@RestController
@RequestMapping("/api/jobexperiences")

public class JobExperiencesController {
		
	
	
	private final JobExperienceService jobExperienceService;

	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	
	
	
	 @GetMapping("/getall")
	 public DataResult<List<JobExperience>> getAll(){
		 return this.jobExperienceService.getAll();
		 }
	 
	 
	 
	 
	
	    @PostMapping("/add")
	    public Result add(@Valid @RequestBody JobExperienceDto jobExperienceDto){
	        return this.jobExperienceService.add(jobExperienceDto);
	    }
	
	
	
}
