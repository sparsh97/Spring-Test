package com.sparsh.SprintLearning.service;

import com.sparsh.SprintLearning.entity.Department;
import com.sparsh.SprintLearning.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentCode("IT-06").departmentName("IT")
                .departmentAddress("Tower 2").build();

        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data Based on Valid Department Name")
    public void whenValidateDepartmentName_thenDepartmentNameMatch(){
        String name="IT";
        Department department= departmentService.findByDeparmentName(name);

        assertEquals(name,department.getDepartmentName());

    }
}