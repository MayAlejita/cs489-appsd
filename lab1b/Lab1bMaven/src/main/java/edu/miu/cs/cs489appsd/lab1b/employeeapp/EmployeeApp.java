package edu.miu.cs.cs489appsd.lab1b.employeeapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cs.cs489appsd.lab1b.employeeapp.model.Employee;
import edu.miu.cs.cs489appsd.lab1b.employeeapp.model.PensionPlan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeApp {
    public static void main(String[] args) throws JsonProcessingException {

        Employee emp1 = new Employee(1L, "Daniel", "Agar", LocalDate.of(2018,01,17),
                BigDecimal.valueOf(105945.50));
        Employee emp2 = new Employee(2L, "Bernard", "Shaw", LocalDate.of(2018,10,03),
                BigDecimal.valueOf(197750.00));
        Employee emp3 = new Employee(3L, "Carly", "Agar", LocalDate.of(2014,05,16),
                BigDecimal.valueOf(842000.75));
        Employee emp4 = new Employee(4L, "Wesley", "Schneider", LocalDate.of(2018,11,02),
                BigDecimal.valueOf(74500.00));

        PensionPlan pp1 = new PensionPlan("EX1089", LocalDate.of(2023,01,17), BigDecimal.valueOf(100.00));
        emp1.addPensionPlan(pp1);
        PensionPlan pp2 = new PensionPlan("SM2307", LocalDate.of(2019,11,04), BigDecimal.valueOf(1555.50));
        emp3.addPensionPlan(pp2);

        var employees = List.of(emp1, emp2, emp3, emp4);
        listAllEmployees(employees);
        monthlyUpcomingEnrolls(employees);
    }

    private static void listAllEmployees(List<Employee> employees) throws JsonProcessingException {
        var employeesOrder = employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary).reversed())
                .collect(Collectors.toList());

        System.out.println("Printed list of Employees in JSON format:");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String jsonEmployees = objectMapper.writeValueAsString(employeesOrder);
        JsonNode jsonNode = objectMapper.readTree(jsonEmployees);
        String result = "[";
        for (JsonNode j : jsonNode){
            result += j.toString() + ",\n";
        }
        result = result.substring(0, result.length()-2) + "]";
        System.out.println(result);
    }

    private static void monthlyUpcomingEnrolls(List<Employee> employees) throws JsonProcessingException {

        Predicate<Employee> getEmployeeC = e -> e.getPensionPlan() == null &&
                    !e.getEmploymentDate().plusYears(5).minusMonths(1).isAfter(LocalDate.now());

        var employeeOrderDate = employees.stream()
                .filter(getEmployeeC)
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .collect(Collectors.toList());

        System.out.println("\n----------------------------------");
        System.out.println("Monthly Upcoming Enrolls report in JSON format:");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String jsonEmployees = objectMapper.writeValueAsString(employeeOrderDate);
        JsonNode jsonNode = objectMapper.readTree(jsonEmployees);
        String result = "[";
        for (JsonNode j : jsonNode){
            result += j.toString() + ",\n";
        }
        result = result.substring(0, result.length()-2) + "]";
        System.out.println(result);
    }


}