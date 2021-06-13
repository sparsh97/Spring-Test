package com.sparsh.SprintLearning.service;

import com.sparsh.SprintLearning.entity.Department;
import com.sparsh.SprintLearning.notfoundexception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepatments();

     public Optional<Department> getDepatentById(Long id) throws NotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartmentById(Long id, Department department);

    public Department findByDeparmentName(String name);
}
