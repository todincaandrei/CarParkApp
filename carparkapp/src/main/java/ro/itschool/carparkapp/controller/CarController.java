package ro.itschool.carparkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.itschool.carparkapp.entity.CarModel;
import ro.itschool.carparkapp.service.CarService;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("view-cars")
    public String viewCars(Model model){
        List<CarModel> carModels = carService.getCar();
        model.addAttribute("cars",carModels);
        return "cars";
    }


    @GetMapping("add-car")
    public String addCar(Model model){
        List<CarModel> cars= carService.getCar();

        model.addAttribute("car",new CarModel());

        return "add-cars";
    }

    @PostMapping("add-new-car")
    public String addNewCar(CarModel car){
        carService.addCar(car);
        return "redirect:/view-cars";
    }

}
