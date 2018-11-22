package com.nf147.entity;

import java.util.List;

public class PersonnelList {
    private List<Personnel> personnels;

    public List<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

    public PersonnelList(List<Personnel> personnels) {
        this.personnels = personnels;
    }

    public PersonnelList() {
    }
}
