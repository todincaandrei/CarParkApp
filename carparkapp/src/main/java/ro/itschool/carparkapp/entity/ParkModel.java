package ro.itschool.carparkapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "park")
public class ParkModel {

    @Id
    private int id;

    private String name;

    private String city;
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
