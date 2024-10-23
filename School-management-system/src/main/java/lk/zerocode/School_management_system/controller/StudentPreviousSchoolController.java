package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.PreviousSchoolRequest;
import lk.zerocode.School_management_system.controller.response.StudentPreviousSchoolResponse;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.service.PreviousSchoolService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentPreviousSchoolController {

    private PreviousSchoolService previousSchoolService;

    @PostMapping(value = "/{student-id}/previous-schools", headers = "X-Api-Version=v1")
    public ResponseEntity<StudentPreviousSchoolResponse> create(@PathVariable ("student-id")Long id,
                                                                @RequestBody PreviousSchoolRequest request) {
        try {
            StudentPreviousSchoolResponse response = previousSchoolService.create(id, request);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
