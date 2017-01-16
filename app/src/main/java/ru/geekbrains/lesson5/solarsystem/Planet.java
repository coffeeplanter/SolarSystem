package ru.geekbrains.lesson5.solarsystem;

class Planet {
    private String planetName;
    private int planetImageId;
    Planet(String name, int imageId) {
        this.planetName = name;
        this.planetImageId = imageId;
    }
    String getPlanetName() {
        return planetName;
    }

    int getPlanetImageId() {
        return planetImageId;
    }
}
