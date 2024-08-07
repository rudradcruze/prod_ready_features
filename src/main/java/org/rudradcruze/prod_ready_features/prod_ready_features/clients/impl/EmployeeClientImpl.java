package org.rudradcruze.prod_ready_features.prod_ready_features.clients.impl;

import lombok.RequiredArgsConstructor;
import org.rudradcruze.prod_ready_features.prod_ready_features.advice.ApiResponse;
import org.rudradcruze.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import org.rudradcruze.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.rudradcruze.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {

//        log.error("error log");
//        log.warn("warn log");
//        log.info("info log");
//        log.debug("debug log");
//        log.trace("trace log");

        log.trace("Trying to retrieved all employees in getAllEmployees");
        try {
            log.info("Attempting to call the restClient Method in getAllEmployees");
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                        log.error(new String(response.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved the employees in getAllEmployees");
            log.trace("Retrieved employees list in getAllEmployees : {}", employeeDTOList.getData());
            return employeeDTOList.getData();
        } catch (Exception e) {
            log.error("Exception occurred in getAllEmployees", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {

        log.trace("Trying to retrieved the employee by id in getEmployeeById with the id : {}", employeeId);

        try {
            log.info("Attempting to call the restClient Method in getEmployeeById");
            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                    .uri("employees/{employeeId}", employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                        log.error(new String(response.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved the employees in getEmployeeById with id : {}", employeeId);
            log.trace("Retrieved employees list in getEmployeeById : {}", employeeResponse.getData());
            return employeeResponse.getData();
        } catch (Exception e) {
            log.error("Exception occurred in getEmployeeById", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        log.trace("Trying to create Employee with information {}", employeeDTO);
        try {
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse = restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                        log.debug("4xxClient error occurred createNewEmployee");
                        log.error(new String(response.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not create the employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });
            log.trace("Successfully create a new employee : {}", employeeDTOApiResponse.getBody());
            return employeeDTOApiResponse.getBody().getData();

        } catch (Exception e) {
            log.error("Exception occurred in createNewEmployee", e);
            throw new RuntimeException(e);
        }
    }


}
