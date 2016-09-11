package com.jxpens.id11965252.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A bean that represents a pen in the inventory.
 * Each pen has a name, nib size, a brand, a colour and a unique database ID.
 * The database ID will be set by the database automatically.
 * @author Shaoxi He
 */
@XmlRootElement(name="pen")
public class Pen {

    private String brand;
    private String colour;
    private double nibSize;
    private String name;
    private int id;

    public Pen() {
    }

    public Pen(String brand, String colour, double nibSize, String name) {
        this.brand = brand;
        this.colour = colour;
        this.nibSize = nibSize;
        this.name = name;
    }

    /**
     * @return the id of the pen
     */
    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    /**
     * Set the id of the pen
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the brand
     */
    @XmlElement(name = "brand")
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
    @XmlElement(name = "colour")
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
    @XmlElement(name = "nibsize")
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
    @XmlElement(name = "pen-name")
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
