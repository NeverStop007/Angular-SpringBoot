package com.consultadd.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consultadd.model.Customers;

@Repository
public interface CustomersRepositry extends JpaRepository<Customers, Long> {

}
