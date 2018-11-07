package com.task.project4.model;
/*
Klasa DeveloperAll - klasy typu DTO(Data Transfer Object), czasami nazywane także VM(View Model)
Klasa używana jest tylko w kontekście widoku - używana tylko przez Thymeleaf i nie jest przechowywana w bazie danych
 */

public class DeveloperAll {

    private Developer developer;
    private DeveloperInfo developerInfo;

    public DeveloperAll() {
    }

    public DeveloperAll(Developer developer, DeveloperInfo developerInfo) {
        this.developer = developer;
        this.developerInfo = developerInfo;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public DeveloperInfo getDeveloperInfo() {
        return developerInfo;
    }

    public void setDeveloperInfo(DeveloperInfo developerInfo) {
        this.developerInfo = developerInfo;
    }
}
