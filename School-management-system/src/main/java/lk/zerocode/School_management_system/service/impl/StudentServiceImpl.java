package lk.zerocode.School_management_system.service.impl;

import lk.zerocode.School_management_system.controller.request.StudentInformationRequest;
import lk.zerocode.School_management_system.controller.request.TeacherRequest;
import lk.zerocode.School_management_system.controller.response.StudentInformationResponse;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.exception.TeacherNotFoundException;
import lk.zerocode.School_management_system.model.*;
import lk.zerocode.School_management_system.repository.GradeRepository;
import lk.zerocode.School_management_system.repository.StudentRepository;
import lk.zerocode.School_management_system.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found for ID: " + studentId));
    }

    @Override
    public Student updateById(StudentInformationRequest request, Long studentId) throws StudentNotFoundException,GradeNotFoundException {

        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found for ID: " + studentId));
        modelMapper.map(request, existingStudent);
        Grade grade = gradeRepository.findById(request.getGrade())
                .orElseThrow(() -> new GradeNotFoundException("Grade not found for ID: " + request.getGrade()));
        existingStudent.setGrade(grade);

        Student updateStudent = studentRepository.save(existingStudent);
        return modelMapper.map(updateStudent, Student.class);
    }

}