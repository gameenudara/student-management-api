package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.response.TeacherControllerResponse;
import lk.zerocode.School_management_system.dto.TeacherDto;
import lk.zerocode.School_management_system.exception.TeacherNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface TeacherService {
    TeacherControllerResponse createTeacher(TeacherDto teacherDto, MultipartFile multipartFile)throws IOException;
}
