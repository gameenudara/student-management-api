package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.PreviousSchoolRequest;
import lk.zerocode.School_management_system.exception.SchoolNotFoundException;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.PreviousSchool;

import java.util.List;


public interface PreviousSchoolService {

    PreviousSchool create(Long id, PreviousSchoolRequest request) throws StudentNotFoundException;

    List<PreviousSchool> getAll(Long id) throws StudentNotFoundException;

    PreviousSchool getById(Long studentId,Long schoolId) throws StudentNotFoundException, SchoolNotFoundException;

    PreviousSchool updateById(Long studentId,Long schoolId,PreviousSchoolRequest request) throws StudentNotFoundException, SchoolNotFoundException;

    void deleteById(Long studentId,Long schoolId) throws StudentNotFoundException, SchoolNotFoundException;
}
