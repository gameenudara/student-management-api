package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.StudentInformationRequest;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.Student;

import java.util.List;

public interface StudentService {

    Student create(StudentInformationRequest request) throws GradeNotFoundException;

    List<Student> getAllStudents();

    Student getStudentById(Long studentId) throws StudentNotFoundException;

    Student updateById(StudentInformationRequest request,Long studentId) throws StudentNotFoundException,GradeNotFoundException;

    void deleteById(Long studentId) throws StudentNotFoundException;
}
