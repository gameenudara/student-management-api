package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.dto.StudentDto;
import lk.zerocode.School_management_system.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/{user-id}/students")
public class StudentController {

    @PostMapping("")
    public void studentRegistration(@ModelAttribute StudentDto studentDto) {


    }
}
