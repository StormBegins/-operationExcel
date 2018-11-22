package com.nf147.entity;

public class Personnel {
    private Integer id;

    private String name;

    private String sex;

    private String education;

    private Double wages;

    public Personnel() {
    }

    public Personnel(Integer id, String name, String sex, String education, Double wages) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.education = education;
        this.wages = wages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Double getWages() {
        return wages;
    }

    public void setWages(Double wages) {
        this.wages = wages;
    }
}