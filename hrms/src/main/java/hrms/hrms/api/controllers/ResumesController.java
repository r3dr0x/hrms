package hrms.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.ResumeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Resume;
import hrms.hrms.entities.dtos.ResumeAddDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	
	
		private final ResumeService resumeService;

		
		@Autowired
		public ResumesController(ResumeService resumeService) {
			
			this.resumeService = resumeService;
		}
		
		
		
		
	    @GetMapping("/getall")
	    public DataResult<List<Resume>> getAll(){
	        return this.resumeService.getAll();
	    }

	    @PostMapping("/add")
	    public Result add(@Valid @RequestBody ResumeAddDto resumeAddDto){
	        return this.resumeService.add(resumeAddDto);
	    }
	    
	    
	    
	    @PutMapping("/uploadimage")
		public Result uploadImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
	    	return this.resumeService.uploadImage(file, resumeId);
	    }
		
}
