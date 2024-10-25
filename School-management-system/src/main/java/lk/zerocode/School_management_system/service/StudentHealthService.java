package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.HealthStatusRequest;
import lk.zerocode.School_management_system.exception.SchoolNotFoundException;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.StudentHealth;

import java.util.List;

public interface StudentHealthService {

    StudentHealth create(Long id, HealthStatusRequest request) throws StudentNotFoundException;

    List<StudentHealth> getAll(Long studentId) throws StudentNotFoundException;

    StudentHealth getById(Long studentId,Long healthId) throws StudentNotFoundException, SchoolNotFoundException;

    StudentHealth updateById(Long studentId,Long healthId,HealthStatusRequest request) throws StudentNotFoundException, SchoolNotFoundException;

    void deleteById(Long studentId,Long healthId) throws StudentNotFoundException, SchoolNotFoundException;
}
