package com.example.demo.studentRecord;

import java.util.List;

public interface SubjectService {

    List<Subject> getSubjects(SubjectDataDTO subjectDataDTO);

    Double getHighestGrade();

    Integer getHighestEcts();

    Double getGradePointAverage();

    Subject createSubject(SubjectDataDTO subjectDataDTO);

    Subject updateSubject(Long id, SubjectDataDTO subjectDataDTO);

    Subject deleteSubject(Long id);
}
