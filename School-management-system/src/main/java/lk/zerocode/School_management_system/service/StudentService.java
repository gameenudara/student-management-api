package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.StudentInformationRequest;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.model.Student;

public interface StudentService {

    Student create(StudentInformationRequest request) throws GradeNotFoundException;


}
