package com.debashish.loadjson.rest;


import com.debashish.loadjson.model.Students;
import com.debashish.loadjson.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class LoadJSONController {

    private final LoadService loadService;

    @GetMapping("/students")
    ResponseEntity<Students> getStudents() {

        Students students = loadService.getStudents();
        return ResponseEntity.ok(students);
    }

}
