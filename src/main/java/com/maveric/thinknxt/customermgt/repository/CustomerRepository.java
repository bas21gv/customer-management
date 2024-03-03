package com.maveric.thinknxt.customermgt.repository;

import com.maveric.thinknxt.customermgt.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
