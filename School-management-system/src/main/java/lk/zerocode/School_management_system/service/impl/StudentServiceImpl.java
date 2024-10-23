package lk.zerocode.School_management_system.service.impl;

import lk.zerocode.School_management_system.controller.request.StudentInformationRequest;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.model.*;
import lk.zerocode.School_management_system.repository.GradeRepository;
import lk.zerocode.School_management_system.repository.StudentRepository;
import lk.zerocode.School_management_system.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private GradeRepository gradeRepository;
    private ModelMapper modelMapper;

    @Override
    public Student create(StudentInformationRequest request) throws GradeNotFoundException {

        Student student = modelMapper.map(request, Student.class);

        Grade grade = gradeRepository.findById(request.getGrade())
                .orElseThrow(() -> new GradeNotFoundException("Grade not found for ID: " + request.getGrade()));
        student.setGrade(grade);
        student.setDraft(Draft.INCOMPLETE);

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, Student.class);
    }

}
