package com.example.demo.flowers;

public class Flower {
    private int id;
    private String name;
    private Color color;
    private boolean beautiful;
    private int height;

    public Flower() {
    }

    public Flower(int id, String name, Color color, boolean beautiful, int height) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.beautiful = beautiful;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isBeautiful() {
        return beautiful;
    }

    public void setBeautiful(boolean beautiful) {
        this.beautiful = beautiful;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
