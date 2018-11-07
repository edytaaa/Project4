package com.task.project4.repository;

import com.task.project4.model.DeveloperInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeveloperInfoRepository extends JpaRepository<DeveloperInfo, Long> {
}
