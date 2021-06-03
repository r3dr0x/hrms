package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertController {
	private final JobAdvertService jobAdvertSerivce;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertSerivce) {
		this.jobAdvertSerivce = jobAdvertSerivce;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll() {
		return this.jobAdvertSerivce.getAll();
	}
	
	@GetMapping("/getactiveis")
	public DataResult<List<JobAdvert>> getByActiveIs() {
		return this.jobAdvertSerivce.getByActiveIs();
	}
	
	@GetMapping("/getbyactiveisandemployerid")
	 public DataResult<List<JobAdvert>> getByActiveIsAndEmployerId(@RequestBody int employerId){
		return this.jobAdvertSerivce.getByActiveIsAndEmployer_Id(employerId);
	}
	
	@PutMapping("/closejobadvert")
	public Result closeJobAdvert(@RequestBody int jobAdvertId) {
		return this.jobAdvertSerivce.closeJobAdvert(jobAdvertId);
	}
}
