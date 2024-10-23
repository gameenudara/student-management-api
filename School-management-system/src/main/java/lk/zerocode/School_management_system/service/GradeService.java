package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.GradeRegisterRequest;
import lk.zerocode.School_management_system.controller.response.GradeRegisterResponse;
import lk.zerocode.School_management_system.model.Grade;

public interface GradeService {

    GradeRegisterResponse create(GradeRegisterRequest request);
}
