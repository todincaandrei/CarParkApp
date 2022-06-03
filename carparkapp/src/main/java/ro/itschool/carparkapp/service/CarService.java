package ro.itschool.carparkapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.carparkapp.entity.CarModel;
import ro.itschool.carparkapp.repository.CarRepository;
import ro.itschool.carparkapp.service.exception.CarNotFoundException;

import java.util.List;
import java.util.Optional;

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

    public CarModel getCarById(int carId) throws CarNotFoundException {
        Optional<CarModel> optionalCarModel = carRepository.findById(carId);

        if (optionalCarModel.isEmpty()){
            throw new CarNotFoundException("Car with id: " + carId + " does not exists");
        }
        CarModel carModel = optionalCarModel.get();

        return carModel;
    }

    public void updateCar(CarModel modifiedCar) throws CarNotFoundException{
        CarModel existingCar = getCarById(modifiedCar.getId());

        existingCar.setBrand(modifiedCar.getBrand());
        existingCar.setColour(modifiedCar.getColour());
        existingCar.setModel(modifiedCar.getModel());
        existingCar.setTransmission(modifiedCar.getTransmission());
        existingCar.setYearOfFabrication(modifiedCar.getYearOfFabrication());

        carRepository.save(existingCar);
    }

    public void removeCar(int carId) {carRepository.deleteById(carId);
    }
}
