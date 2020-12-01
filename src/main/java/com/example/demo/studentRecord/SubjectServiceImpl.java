package com.example.demo.studentRecord;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {
    List<Subject> subjects = new ArrayList<>(Arrays.asList(
            new Subject(1L, "accountancy", SubjectType.PRACTICALS, 5d, 3),
            new Subject(2L, "accountancy", SubjectType.SEMINAR, 5d, 5),
            new Subject(3L, "management accounting", SubjectType.PARLOUR, 4.5d, 2),
            new Subject(4L, "business plan", SubjectType.LECTURE, 4d, 4),
            new Subject(5L, "business plan", SubjectType.PRACTICALS, 4.5d, 1),
            new Subject(6L, "computer science", SubjectType.LABORATORY, 3.5d, 3)
    ));

    @Override
    public List<Subject> getSubjects(SubjectDataDTO subjectDataDTO) {
        return subjects.stream()
                .filter(subject -> {
                    if(subjectDataDTO.getSubjectName() != null) {
                        return subject.getSubjectName().startsWith(subjectDataDTO.getSubjectName());
                    }
                    return true;
                })
                .filter(subject -> {
                    if(subjectDataDTO.getSubjectType() != null) {
                        return subject.getSubjectType().equals(subjectDataDTO.getSubjectType());
                    }
                    return true;
                })
                .filter(subject -> {
                    if(subjectDataDTO.getGrade() != null) {
                        return subject.getGrade().equals(subjectDataDTO.getGrade());
                    }
                    return true;
                })
                .filter(subject -> {
                    if(subjectDataDTO.getEcts() != null) {
                        return subject.getEcts().equals(subjectDataDTO.getEcts());
                    }
                    return true;
                })
                .collect(Collectors.toList());

    }

    @Override
    public Double getHighestGrade() {
        return subjects.stream()
                .map(Subject::getGrade)
                .max(Comparator.comparingDouble(a -> a))
                .orElseThrow(() -> new RuntimeException("There are no grades"));
    }

    @Override
    public Integer getHighestEcts() {
        return subjects.stream()
                .map(Subject::getEcts)
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("There are no ECTS"));
    }

    @Override
    public Double getGradePointAverage() {
        double average = subjects.stream()
                .map(Subject::getGrade)
                .reduce(Double::sum)
                .orElse(0d) / subjects.size();
        BigDecimal bigDecimal = new BigDecimal(Double.toString(average));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    @Override
    public Subject createSubject(SubjectDataDTO subjectDataDTO) {
        Long id = subjects.stream()
                .map(Subject::getId)
                .max(Comparator.comparingLong(a -> a))
                .orElse(0L) + 1L;
        Subject subject = new Subject(id, subjectDataDTO.getSubjectName(), subjectDataDTO.getSubjectType(),
                subjectDataDTO.getGrade(), subjectDataDTO.getEcts());
        subjects.add(subject);
        return subject;
    }

    @Override
    public Subject updateSubject(Long id, SubjectDataDTO subjectDataDTO) {
        Subject updatedSubject = getSubjectById(id);
        if(subjectDataDTO.getSubjectName() != null) updatedSubject.setSubjectName(subjectDataDTO.getSubjectName());
        if(subjectDataDTO.getSubjectType() != null) updatedSubject.setSubjectType(subjectDataDTO.getSubjectType());
        if(subjectDataDTO.getGrade() != null) updatedSubject.setGrade(subjectDataDTO.getGrade());
        if(subjectDataDTO.getEcts() != null) updatedSubject.setEcts(subjectDataDTO.getEcts());
        return updatedSubject;
    }

    @Override
    public Subject deleteSubject(Long id) {
        Subject deletedSubject = getSubjectById(id);
        subjects.remove(deletedSubject);
        return deletedSubject;
    }

    private Subject getSubjectById(Long id) {
        return subjects.stream()
                .filter(subject -> subject.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }
}
