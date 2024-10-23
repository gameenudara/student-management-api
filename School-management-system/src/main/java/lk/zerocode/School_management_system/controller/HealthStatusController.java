package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.HealthStatusRequest;
import lk.zerocode.School_management_system.controller.response.HealthStatusResponse;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.Parent;
import lk.zerocode.School_management_system.model.StudentHealth;
import lk.zerocode.School_management_system.service.StudentHealthService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class HealthStatusController {

    private StudentHealthService studentHealthService;
    private ModelMapper modelMapper;

    @PostMapping(value = "/{student-id}/health-status", headers = "X-Api-Version=v1")
    public ResponseEntity<?> create(@RequestBody HealthStatusRequest request, @PathVariable("student-id") Long id) throws StudentNotFoundException {

        StudentHealth savedStudentHealth = studentHealthService.create(request, id);
        HealthStatusResponse response = modelMapper.map(savedStudentHealth, HealthStatusResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
