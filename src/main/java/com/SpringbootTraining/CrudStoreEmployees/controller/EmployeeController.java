package com.SpringbootTraining.CrudStoreEmployees.controller;

import com.SpringbootTraining.CrudStoreEmployees.model.StoreEmployee;
import com.SpringbootTraining.CrudStoreEmployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //post api for adding employees
    @PostMapping("/addEmployees")
    public StoreEmployee addEmployees(@RequestBody StoreEmployee storeEmployee) {
        return service.saveEmployee(storeEmployee);
    }

    //post api for adding a list of multiple employees
    @PostMapping("/addMultipleEmployees")
    public List<StoreEmployee> addMultipleEmployees(@RequestBody List<StoreEmployee> storeEmployees) {
        return service.saveEmployee(storeEmployees);
    }

    //api to list all employees
    @GetMapping("/allEmployees")
    public List<StoreEmployee> findAllEmployees() {
        return service.getEmployees();
    }

    //fetching employees by id
    @GetMapping("/employeesById/{id}")
    public StoreEmployee findEmployeesById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    //fetching employees by last name
    @GetMapping("/employeesByLname/{lname}")
    public StoreEmployee findEmployeeByLname(@PathVariable String lname) {
        return service.getEmployeeByLname(lname);
    }

    //fetching employees by email

    public StoreEmployee findEmployeeByEmail(@PathVariable String email) {
        return service.getEmployeeByEmail(email);
    }

    //fetching employees by birthyear
    @GetMapping("/employeesByBirthyear/{birthyear")
    public StoreEmployee findEmployeeByBirthyear(@PathVariable String birthyear) {
        return service.getEmployeeByBirthyear(birthyear);
    }

    //Updating Employees
    @PutMapping("/updateEmployee")
    public StoreEmployee updateEmployee(@RequestBody StoreEmployee storeEmployee) {
        return service.updateEmployee(storeEmployee);
    }

    //Deleting Employees by id
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

}