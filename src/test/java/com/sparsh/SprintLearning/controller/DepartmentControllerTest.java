package com.sparsh.SprintLearning.controller;

import com.sparsh.SprintLearning.entity.Department;
import com.sparsh.SprintLearning.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        department= Department.builder().departmentCode("CSE-01")
                .departmentAddress("Tower 1")
                .departmentName("CSE")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
       Department inputDep= Department.builder().departmentCode("CSE-01")
                .departmentAddress("Tower 1")
                .departmentName("CSE")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDep))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
            .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "    \"departmentName\": \"CSE\",\n" +
                        "    \"departmentAddress\": \"Tower 1\",\n" +
                        "    \"departmentCode\": \"CSE-01\"\n" +
                        "}")).andExpect(status().isCreated());

    }

    @Test
    void getDepartmentById() {
    }
}