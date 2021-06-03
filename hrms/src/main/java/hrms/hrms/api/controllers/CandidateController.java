package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
		private final CandidateService candidateService;
		
		
		@Autowired
		public CandidateController (CandidateService candidateService) {
			this.candidateService = candidateService;
			
		}
		
		@GetMapping("/getAll")
		public DataResult<List<Candidate>> getAll(){
			return this.candidateService.getAll();
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody Candidate candidate) {
			return this.candidateService.add(candidate);
		}
		
		
		
}
