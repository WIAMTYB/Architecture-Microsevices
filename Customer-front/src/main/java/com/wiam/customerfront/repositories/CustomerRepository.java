package com.wiam.customerfront.repositories;




import com.wiam.customerfront.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
