package ro.itschool.carparkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.itschool.carparkapp.entity.ParkModel;
import ro.itschool.carparkapp.service.ParkService;
import ro.itschool.carparkapp.service.exception.ParkNotFoundException;

import java.util.List;

@Controller
public class ParkController {

    @Autowired
    private ParkService parkService;


    @GetMapping("view-parks")
    private String viewPark(Model myModel) {
        List<ParkModel> parkModelsList = parkService.getPark();
        myModel.addAttribute("parks", parkModelsList);
        return "parks";
    }

    @GetMapping("add-park")
    public String addParkPage(Model model) {
        model.addAttribute("park", new ParkModel());
        return "add-park";
    }

    @PostMapping("add-new-park")
    public String addNewPark(ParkModel parkModel) {
        parkService.addPark(parkModel);
        return "redirect:/view-parks";
    }

    @GetMapping("edit-parks-page/{parkId}")
    public String editParkPage(@PathVariable("parkId") int parkId, Model model) throws ParkNotFoundException {


        ParkModel parkModel = parkService.getParkById(parkId);


        model.addAttribute("park", parkModel);


        return "edit-park";
    }


    @PostMapping("edit-parks")
    public String editParks(ParkModel parkModel) throws ParkNotFoundException {
        parkService.updateParks(parkModel);
        return "redirect:/view-parks";
    }


    @GetMapping("delete-park/{id}")
    public String deleteDepartment(@PathVariable("id") int parkId){
        parkService.removePark(parkId);
        return "redirect:/view-parks";
    }
}
