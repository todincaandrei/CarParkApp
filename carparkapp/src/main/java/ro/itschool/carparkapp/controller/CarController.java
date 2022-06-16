package ro.itschool.carparkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.itschool.carparkapp.entity.CarModel;
import ro.itschool.carparkapp.entity.ParkModel;
import ro.itschool.carparkapp.service.CarService;
import ro.itschool.carparkapp.service.ParkService;
import ro.itschool.carparkapp.service.exception.CarNotFoundException;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private ParkService parkService;

    @GetMapping("view-cars")
    public String viewCars(Model model) {
        List<CarModel> carModels = carService.getCar();
        model.addAttribute("cars", carModels);
        return "cars";
    }

    @GetMapping("add-car")
    public String addCar(Model model) {

        List<ParkModel> parks = parkService.getPark();

        model.addAttribute("car", new CarModel());
        model.addAttribute("parks", parks);

        return "add-cars";
    }

    @PostMapping("add-new-car")
    public String addNewCar(CarModel car) {
        carService.addCar(car);
        return "redirect:/view-cars";
    }

    @GetMapping("edit-car-page/{carId}")
    public String editCarPage(@PathVariable("carId") int carId, Model model) throws CarNotFoundException {

        CarModel carModel = carService.getCarById(carId);

        List<ParkModel> parks = parkService.getPark();
        model.addAttribute("parks", parks);
        model.addAttribute("car", carModel);

        return "edit-car";
    }

    @PostMapping("edit-new-car")
    public String editCar(CarModel carModel) throws CarNotFoundException {
        carService.updateCar(carModel);

        return "redirect:/view-cars";
    }

    @GetMapping("delete-car/{id}")
    public String deleteCar(@PathVariable("id") int carId) {
        carService.removeCar(carId);
        return "redirect:/view-cars";
    }

    @RequestMapping(path = {"/","/search"})
    public String searchByModel(CarModel carModel, Model model, String keyword) {
        if(keyword!=null) {
            List<CarModel> list = carService.searchByModel(keyword);
            model.addAttribute("cars", list);
        }else {
            List<CarModel> list = carService.getCar();
            model.addAttribute("cars", list);}
        return "cars";
    }

    @GetMapping("home")
    public String home(){
        return "index";
    }
}
