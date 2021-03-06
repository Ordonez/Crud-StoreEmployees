package com.SpringbootTraining.CrudStoreEmployees.repository;

import com.SpringbootTraining.CrudStoreEmployees.model.StoreEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<StoreEmployee,Integer> {
    StoreEmployee findByLname(String lname);

    StoreEmployee findByBirthyear(String birthyear);

    StoreEmployee findByEmail(String email);
}
