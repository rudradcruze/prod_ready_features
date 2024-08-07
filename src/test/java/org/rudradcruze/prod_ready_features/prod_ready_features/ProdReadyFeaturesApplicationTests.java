package org.rudradcruze.prod_ready_features.prod_ready_features;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.rudradcruze.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import org.rudradcruze.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
class ProdReadyFeaturesApplicationTests {

    @Autowired
    private EmployeeClient employeeClient;

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    void createNewEmployeeTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO(
                null,
                "Rudi",
                "rudi@gmail.com",
                2,
                "ADMIN",
                10000.00,
                LocalDate.of(2023, 07, 15),
                true,
                7,
                LocalDate.of(2025, 07, 05),
                "7992-7398-713",
                5000f,
                false,
                "Abc@123456"
        );
        EmployeeDTO savedEmployeeDto = employeeClient.createNewEmployee(employeeDTO);
        System.out.println(savedEmployeeDto);
    }

    @Test
    @Order(2)
    void getAllEmployeesTest() {
        List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
        System.out.println(employeeDTOList.toString());
    }

    @Test
    @Order(3)
    void getEmployeeByIdTest() {
        EmployeeDTO employeeDTO = employeeClient.getEmployeeById(3L);
        System.out.println(employeeDTO);
    }

}
