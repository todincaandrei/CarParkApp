package ro.itschool.carparkapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CarId;

    private String brand;

    private String model;

    private String colour;
    private String transmission;

    private int yearOfFabrication;
    public String getTransmission() {
        return transmission;
    }

    @ManyToOne
    private ParkModel park;

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(int yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int carId) {
        CarId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}
