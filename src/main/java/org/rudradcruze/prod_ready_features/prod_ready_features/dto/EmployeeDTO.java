package org.rudradcruze.prod_ready_features.prod_ready_features.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String role;
    private double salary;
    private LocalDate dateOfJoining;
    private Boolean isActive;
    private Integer primeNumber;
    private LocalDate possibleLeaveDate;
    private String creditCardNumber;
    private Float creditCardLimit;
    private Boolean isManager;
    private String password;
}
