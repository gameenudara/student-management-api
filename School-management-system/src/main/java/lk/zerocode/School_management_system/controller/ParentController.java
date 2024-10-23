package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.ParentRegisterRequest;
import lk.zerocode.School_management_system.model.Parent;
import lk.zerocode.School_management_system.service.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/parents")
public class ParentController {

    private ParentService parentService;

    @PostMapping(value = "", headers = "X-Api-Version=v1")
    public ResponseEntity<Parent> create(@RequestBody ParentRegisterRequest request) {

        Parent parent = parentService.create(request);
        return new ResponseEntity<>(parent, HttpStatus.CREATED);
    }

//    @PostMapping(value = "/parents-students/{student-id}", headers = "X-Api-Version=v1")
//    public void createStudent(@RequestBody StudentParentMapRequest request,
//                                           @PathVariable("student-id") Long studentId) throws StudentNotFoundException {
//
//        parentService.mapParentStudent(studentId,request);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
}
