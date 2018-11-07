package com.task.project4.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Developer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

//Informacje ogólne:
private String name;
private String url;
private String description;

@OneToOne //(mappedBy = "developer")
private DeveloperInfo developerInfo;

@OneToMany(mappedBy = "developer")
private List<Investment> investmentList;

    public Developer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DeveloperInfo getDeveloperInfo() {
        return developerInfo;
    }

    public void setDeveloperInfo(DeveloperInfo developerInfo) {
        this.developerInfo = developerInfo;
    }

    public List<Investment> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<Investment> investmentList) {
        this.investmentList = investmentList;
    }
}
