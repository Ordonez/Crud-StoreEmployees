package com.SpringbootTraining.CrudStoreEmployees.service;

import com.SpringbootTraining.CrudStoreEmployees.model.StoreEmployee;
import com.SpringbootTraining.CrudStoreEmployees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;


    //Creating Post methods
    public StoreEmployee saveEmployee(StoreEmployee storeEmployee) {
        return repository.save(storeEmployee);
    }
    public List<StoreEmployee> saveEmployee(List<StoreEmployee> storeEmployee) {
        return repository.saveAll(storeEmployee);
    }

    //Creating Get methods to fetch employees from database
    public List <StoreEmployee> getEmployees() {
        return repository.findAll();
    }
    public StoreEmployee getEmployeeById(int id) {
        return repository.findById(id).orElse(null); // if an id is not picked up then return null
    }
    //To fetch data based on name
    public StoreEmployee getEmployeeByName(String name) {
        return repository.findByName(name);
    }

    //Deleting employees
    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee removed" +id;
    }

    //Updating employees
    public StoreEmployee updateEmployee(StoreEmployee storeEmployee) {
        StoreEmployee existingEmployees=repository.findById(storeEmployee.getId()).orElse(null);
        existingEmployees.setFname(storeEmployee.getFname());
        existingEmployees.setLname(storeEmployee.getLname());
        existingEmployees.setEmail(storeEmployee.getEmail());
        existingEmployees.setBirthyear(storeEmployee.getBirthyear());

        return repository.save(existingEmployees);


    }
}
