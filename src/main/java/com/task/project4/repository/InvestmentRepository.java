package com.task.project4.repository;

import com.task.project4.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    @Query(value = "select * from Investment where developer_id=:id", nativeQuery = true)
    List<Investment> findByDeveloper(@Param("id") Long id);

//    //LUB 2:
//    List<Investment> findByDeveloper(Developer developer);

//    //LUB 3:
//    List<Investment> findByDeveloperId(Long id);

}