package com.sparsh.SprintLearning.service;

import com.sparsh.SprintLearning.entity.Department;
import com.sparsh.SprintLearning.notfoundexception.NotFoundException;
import com.sparsh.SprintLearning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DeparmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepatments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepatentById(Long id) throws NotFoundException {
        Optional<Department> department= departmentRepository.findById(id);
        if(department.isPresent()){
            return department;
        }else{
            throw  new NotFoundException("Department not found by given id");
        }
    }

    @Override
    public void deleteDepartmentById(Long id) {
        Optional<Department> department= departmentRepository.findById(id);
        if(department.isPresent()){
            departmentRepository.deleteById(id);
        }else{
            throw new RuntimeException("Id not found");
        }
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Optional<Department> dep= departmentRepository.findById(id);
        if(dep.isPresent()){
            if(Objects.nonNull(dep.get().getDepartmentName()) &&
                    !"".equalsIgnoreCase(dep.get().getDepartmentName())){
                dep.get().setDepartmentName(department.getDepartmentName());
            }
            if(Objects.nonNull(dep.get().getDepartmentAddress()) &&
                    !"".equalsIgnoreCase(dep.get().getDepartmentAddress())){
                dep.get().setDepartmentAddress(department.getDepartmentAddress());
            }
            if(Objects.nonNull(dep.get().getDepartmentCode()) &&
                    !"".equalsIgnoreCase(dep.get().getDepartmentCode())){
                dep.get().setDepartmentCode(department.getDepartmentCode());
            }
             return departmentRepository.save(dep.get());
        }else{
            throw new RuntimeException("Id not found.\n");
        }
    }

    @Override
    public Department findByDeparmentName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }
}
