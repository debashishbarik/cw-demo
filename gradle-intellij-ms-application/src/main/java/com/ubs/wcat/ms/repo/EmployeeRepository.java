package com.ubs.wcat.ms.repo;

import com.ubs.wcat.ms.domain.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
