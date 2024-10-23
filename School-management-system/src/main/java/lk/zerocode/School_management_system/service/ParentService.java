package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.ParentRegisterRequest;
import lk.zerocode.School_management_system.controller.request.StudentParentMapRequest;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.Parent;

public interface ParentService {

    Parent create(ParentRegisterRequest request);

    void mapParentStudent(Long  id, StudentParentMapRequest request) throws StudentNotFoundException;

}
