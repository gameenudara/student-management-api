package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.dto.TeacherDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacherDto, MultipartFile multipartFile)throws IOException;
}
