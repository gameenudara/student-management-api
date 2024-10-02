package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.dto.TeacherDto;
import lk.zerocode.School_management_system.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/api/teachers")
    public TeacherDto addTeacher(@RequestBody TeacherDto teacherDto, @RequestParam MultipartFile file)throws Exception {
        return teacherService.createTeacher(teacherDto,file);
    }
}
