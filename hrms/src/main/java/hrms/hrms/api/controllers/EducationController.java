package hrms.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.EducationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Education;
import hrms.hrms.entities.dtos.EducationDto;

@RestController
@RequestMapping("/api/education")
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
