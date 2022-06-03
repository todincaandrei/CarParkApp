package ro.itschool.carparkapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.carparkapp.entity.CarModel;
import ro.itschool.carparkapp.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;



    public List<CarModel> getCar(){
        List<CarModel> models = carRepository.findAll();
        return models;
    }

    public void addCar(CarModel carModel) {carRepository.save(carModel);
    }
}
