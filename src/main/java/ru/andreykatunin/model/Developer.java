package ru.andreykatunin.model;

public class Developer {
    private int id;
    private String name;
    private String commonContacts;
    private String viewContacts;
    private String viewTime;

    public Developer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonContacts() {
        return commonContacts;
    }

    public void setCommonContacts(String commonContacts) {
        this.commonContacts = commonContacts;
    }

    public String getViewContacts() {
        return viewContacts;
    }

    public void setViewContacts(String viewContacts) {
        this.viewContacts = viewContacts;
    }

    public String getViewTime() {
        return viewTime;
    }

    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }
}
