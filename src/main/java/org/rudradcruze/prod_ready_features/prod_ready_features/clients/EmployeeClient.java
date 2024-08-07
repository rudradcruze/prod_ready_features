package org.rudradcruze.prod_ready_features.prod_ready_features.clients;


import org.rudradcruze.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
