package com.ubs.wcat.ms.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.wcat.ms.model.Employee;
import com.ubs.wcat.ms.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Spring boot 2 mockito2 Junit5 example")
public class EmployeeResourceV1Test {

    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;
/*    @Test
    public void getAllEmployeesAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/v1/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].id").isNotEmpty());
    }
*/
    @Test
    @DisplayName("POST /v1/employees- Success")
    void testCreateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setRole("Admin");
        employee.setName("Peter Parker");
        String jsonString = asJsonString(employee);
        System.out.println(jsonString);
        doReturn(employee).when(employeeService).newEmployee(Mockito.any(Employee.class));
        mockMvc.perform(post("/v1/employees").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Peter Parker")))
                .andExpect(jsonPath("$.role", is("Admin")));

    }

    @Test
    @DisplayName("GET /v1/employees/1 - Found")
    void testEmployeeByIdFound() throws Exception {
        Employee mockedEmployee = new Employee();
        mockedEmployee.setId(1L);
        mockedEmployee.setName("Tony Stark");
        mockedEmployee.setRole("User");
        doReturn(Optional.of(mockedEmployee)).when(employeeService).findEmployeeById(1L);
        mockMvc.perform(get("/v1/employees/{id}",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               // .andExpect(header().string(HttpHeaders.LOCATION,"/v1/employees/1"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Tony Stark")))
                .andExpect(jsonPath("$.role", is("User")));
    }
    @Test
    @DisplayName("GET /v1/employees/1 - NotFound")
    void testCustomerByIdNotFound() throws Exception {
        doReturn(Optional.empty()).when(employeeService).findEmployeeById(1L);
        mockMvc.perform(get("/v1/employees/{id}",1))
                //validate that we get 404 Not found response
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Delete /customers/1 - Success")
    void testCustomerDeleteSuceess() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Tony Stark");
        doReturn(Optional.of(employee)).when(employeeService).findEmployeeById(1L);
       // doReturn(true).when(employeeService).deleteEmployee(1);

        mockMvc.perform(delete("/v1/employees/{id}",1))
                .andExpect(status().isAccepted());

    }

    static String asJsonString(final Object obj ) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
