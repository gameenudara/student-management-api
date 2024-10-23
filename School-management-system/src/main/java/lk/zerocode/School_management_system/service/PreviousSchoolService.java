package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.PreviousSchoolRequest;
import lk.zerocode.School_management_system.controller.response.StudentPreviousSchoolResponse;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;


public interface PreviousSchoolService {

    StudentPreviousSchoolResponse  create(Long id, PreviousSchoolRequest request) throws StudentNotFoundException;
}
