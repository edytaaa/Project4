package com.task.project4.repository;

import com.task.project4.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
