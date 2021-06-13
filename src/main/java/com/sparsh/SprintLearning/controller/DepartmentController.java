package com.sparsh.SprintLearning.controller;

import com.sparsh.SprintLearning.entity.Department;
import com.sparsh.SprintLearning.notfoundexception.NotFoundException;
import com.sparsh.SprintLearning.response.ResponseHandler;
import com.sparsh.SprintLearning.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside Save Depatment Controller");
        Department department1= departmentService.saveDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    @GetMapping("/departments")
    public ResponseEntity<Object> getAllDepartments(){
        return ResponseHandler.generateResponse("Success",HttpStatus.OK,departmentService.getAllDepatments());
//        return new ResponseEntity<>(departmentService.getAllDepatments(),HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity(departmentService.getDepatentById(id),HttpStatus.OK);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Department> deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("departments/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable("id") Long id, @RequestBody Department department){
        return new ResponseEntity<>(departmentService.updateDepartmentById(id,department),HttpStatus.OK);
    }

    @GetMapping("/departments/name/{name}")
    public ResponseEntity<Department> findByDepartmentName(@PathVariable("name") String name){
        return new ResponseEntity<>(departmentService.findByDeparmentName(name),HttpStatus.OK);
    }

}
