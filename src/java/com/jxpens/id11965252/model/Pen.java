package com.jxpens.id11965252.model;

/**
 * Pen (Data Transfer Object or Model)
 * Contains basic attributes of a Pen
 * @author Shaoxi He 11965252
 */
public class Pen {

    private String brand;
    private String colour;
    private double nibSize;
    private String name;

    public Pen() {
    }

    public Pen(String brand, String colour, double nibSize, String name) {
        this.brand = brand;
        this.colour = colour;
        this.nibSize = nibSize;
        this.name = name;
    }
    
    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set the brand
     * @param brand 
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the Colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Set the Colour
     * @param colour 
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * @return the nib size
     */
    public double getNibSize() {
        return nibSize;
    }

    /**
     * Set the nib size using a double
     * @param nibSize 
     */
    public void setNibSize(double nibSize) {
        this.nibSize = nibSize;
    }

    /**
     * @return the name of the pen
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
