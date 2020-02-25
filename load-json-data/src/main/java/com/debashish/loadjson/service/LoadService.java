package com.debashish.loadjson.service;

import com.debashish.loadjson.model.Student;
import com.debashish.loadjson.model.Students;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LoadService {

    @Value("classpath:data/student.json")
    Resource resourceFile;

    private Students students;

    @PostConstruct
    public void init() {
        if (students == null) {
            students = loadStudents();
        }
    }

    public Students getStudents() {
        Students students = this.students;
        List<Student> studentList = students.getData();
        List<Student> studentUpdateList = studentList.stream().filter(student -> "India".equals(student.getCountry())).collect(Collectors.toList());
        return new Students(studentUpdateList);
    }

    private Students loadStudents() {
        Students students = null;
        try {
            InputStream inputStream = resourceFile.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            students = objectMapper.readValue(inputStream, Students.class);
        } catch (IOException e) {
            log.error("Loading failed:" + e.getMessage());
        }
        return students;
    }

}
