package ru.andreykatunin.model;

public class RealtyType {
    private int id;
    private String name;

    public RealtyType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}