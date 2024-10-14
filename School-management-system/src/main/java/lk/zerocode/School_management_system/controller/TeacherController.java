package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.TeacherControllerRequest;
import lk.zerocode.School_management_system.controller.response.TeacherControllerResponse;
import lk.zerocode.School_management_system.exception.TeacherNotFoundException;
import lk.zerocode.School_management_system.model.Teacher;
import lk.zerocode.School_management_system.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
    public class TeacherController {

        private final TeacherService teacherService;
        private final ModelMapper modelMapper;

    @PostMapping("/teachers")
    public ResponseEntity<TeacherControllerResponse> createTeacher(@RequestBody TeacherControllerRequest teacherControllerRequest) {
            Teacher teacher = teacherService.createTeacher(teacherControllerRequest);
            TeacherControllerResponse teacherControllerResponse = modelMapper.map(teacher,TeacherControllerResponse.class);
            return new ResponseEntity<>(teacherControllerResponse, HttpStatus.CREATED);
        }

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherControllerResponse>> getAllTeachers() {
        List<Teacher> teacherList = teacherService.readAllTeachers();
        List<TeacherControllerResponse> teacherControllerResponseList = teacherList.stream().map(teacher -> modelMapper.map(teacher, TeacherControllerResponse.class)).toList();
        return new ResponseEntity<>(teacherControllerResponseList,HttpStatus.OK);
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity<TeacherControllerResponse> getTeacherById(@PathVariable("id") Long id) throws TeacherNotFoundException {
        Teacher teacher = teacherService.getSpecificTeacherById(id);
        TeacherControllerResponse teacherControllerResponse = modelMapper.map(teacher, TeacherControllerResponse.class);
        return new ResponseEntity<>(teacherControllerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/teachers")
    public ResponseEntity<TeacherControllerResponse> deleteTeacherById(@PathVariable("id") Long id) throws TeacherNotFoundException {
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/teachers")
    public ResponseEntity<TeacherControllerResponse>updateById(@PathVariable("id") Long id, @RequestBody TeacherControllerRequest teacherControllerRequest) throws TeacherNotFoundException {
        Teacher teacher = teacherService.updateSpecificTeacherById(id,teacherControllerRequest);
        TeacherControllerResponse teacherControllerResponse = modelMapper.map(teacher, TeacherControllerResponse.class);
        return new ResponseEntity<>(teacherControllerResponse, HttpStatus.OK);
    }

    }

