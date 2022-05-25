package ro.itschool.carparkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.itschool.carparkapp.entity.ParkModel;
import ro.itschool.carparkapp.service.ParkService;

import java.util.List;

@Controller
public class ParkController {

    @Autowired
    private ParkService parkService;

    @GetMapping("view-parks")
    private String viewPark(Model myModel){
        List<ParkModel> parkModelsList = parkService.getPark();
        myModel.addAttribute("parks",parkModelsList);
        return "parks";
    }

}
