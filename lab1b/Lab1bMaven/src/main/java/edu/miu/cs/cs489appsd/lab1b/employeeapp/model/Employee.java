package edu.miu.cs.cs489appsd.lab1b.employeeapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private BigDecimal yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, BigDecimal yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public BigDecimal getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(BigDecimal yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void addPensionPlan(PensionPlan pensionPlan){
        this.pensionPlan = pensionPlan;
    }
}
