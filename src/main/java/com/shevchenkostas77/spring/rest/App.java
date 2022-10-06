package com.shevchenkostas77.spring.rest;

import com.shevchenkostas77.spring.rest.configuration.MyConfig;
import com.shevchenkostas77.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication"
                , Communication.class);

        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        Employee empById = communication.getEmployee(1);
        System.out.println(empById);

        Employee empAdd = new Employee("Sveta", "Sokolova"
                , "HR", 900);
        communication.saveEmployee(empAdd);

        Employee empUpdate = new Employee("Sveta", "Sokolova"
                , "IT", 1200);
        empUpdate.setId(12);
        communication.saveEmployee(empUpdate);

        communication.deleteEmployee(12);
    }
}
