package lk.zerocode.School_management_system.service.impl;

import lk.zerocode.School_management_system.controller.response.TeacherControllerResponse;
import lk.zerocode.School_management_system.dto.TeacherDto;
import lk.zerocode.School_management_system.model.Teacher;
import lk.zerocode.School_management_system.repository.TeacherRepository;
import lk.zerocode.School_management_system.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private ModelMapper modelMapper;

    @Override
    public TeacherControllerResponse createTeacher(TeacherDto teacherDto) throws IOException {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);

        teacherRepository.save(teacher);
        return null;
    }
}
