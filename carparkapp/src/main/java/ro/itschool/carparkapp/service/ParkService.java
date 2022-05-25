package ro.itschool.carparkapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.itschool.carparkapp.entity.ParkModel;
import ro.itschool.carparkapp.repository.ParkRepository;

import java.util.List;

@Component
public class ParkService {

//    add get delete

    @Autowired
    private ParkRepository parkRepository;

    public void addPark(ParkModel parkModel){
        parkRepository.save(parkModel);
    }




    public void removePark(int ParkId) {
        parkRepository.deleteById(ParkId);
    }


    public List<ParkModel> getPark() {
        return parkRepository.findAll();

    }

}

