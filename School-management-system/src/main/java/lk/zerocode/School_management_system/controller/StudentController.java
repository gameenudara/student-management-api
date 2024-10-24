package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.StudentInformationRequest;
import lk.zerocode.School_management_system.controller.response.StudentInformationResponse;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.model.Student;
import lk.zerocode.School_management_system.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;
    private ModelMapper modelMapper;

    @PostMapping(value = "", headers = "X-Api-Version=v1")
    public ResponseEntity<?> create(@RequestBody StudentInformationRequest request) {

        try {
            Student createdStudent = studentService.create(request);
            StudentInformationResponse response = modelMapper.map(createdStudent, StudentInformationResponse.class);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (GradeNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }

    }

}
