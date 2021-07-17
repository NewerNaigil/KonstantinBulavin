package ru.training.at.hw7.entities;

import io.cucumber.java.bs.I;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MetalAndColorsData {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public List<String> getExpectedData() {
        List<String> expectedData = new ArrayList<>();
        expectedData.add("Summary: " + summary.stream().flatMapToInt(IntStream::of).sum());
        expectedData.add("Elements: " + Arrays.toString(elements.toArray())
                                              .replace("[", "")
                                              .replace("]", ""));
        expectedData.add("Color: " + color);
        expectedData.add("Metal: " + metals);
        expectedData.add("Vegetables: " + Arrays.toString(vegetables.toArray())
                                              .replace("[", "")
                                              .replace("]", ""));
        return expectedData;
    }
}
