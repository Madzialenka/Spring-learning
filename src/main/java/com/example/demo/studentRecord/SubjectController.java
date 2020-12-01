package com.example.demo.studentRecord;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("studentRecord")
@RestController
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getSubjects(SubjectDataDTO subjectDataDTO){
        return subjectService.getSubjects(subjectDataDTO);
    }

    @GetMapping("highestGrade")
    public Double getHighestGrade(){
        return subjectService.getHighestGrade();
    }

    @GetMapping("highestEcts")
    public Integer getHighestEcts(){
        return subjectService.getHighestEcts();
    }

    @GetMapping("gradePointAverage")
    public Double getGradePointAverage(){
        return subjectService.getGradePointAverage();
    }

    @PostMapping
    public Subject createSubject(@RequestBody SubjectDataDTO subjectDataDTO){
        return subjectService.createSubject(subjectDataDTO);
    }

    @PutMapping("{id}")
    public Subject updateSubject(@PathVariable("id") Long id, @RequestBody SubjectDataDTO subjectDataDTO){
        return subjectService.updateSubject(id, subjectDataDTO);
    }

    @DeleteMapping("{id}")
    public Subject deleteSubject(@PathVariable("id") Long id){
        return subjectService.deleteSubject(id);
    }
}
