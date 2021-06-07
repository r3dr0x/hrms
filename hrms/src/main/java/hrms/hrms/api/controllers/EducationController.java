package hrms.hrms.api.controllers;

import java.util.List;

import hrms.hrms.business.abstracts.EducationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Education;
import hrms.hrms.entities.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(value="/api/education")
public class EducationController {
		
    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }


    @GetMapping("/getall")
    public DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody EducationDto educationDto){
        return this.educationService.add(educationDto);
    }
	
}
