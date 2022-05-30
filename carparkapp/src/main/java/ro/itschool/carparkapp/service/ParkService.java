package ro.itschool.carparkapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.itschool.carparkapp.entity.ParkModel;
import ro.itschool.carparkapp.repository.ParkRepository;
import ro.itschool.carparkapp.service.exception.ParkNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ParkService {



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

    public ParkModel getParkById(int parkId) throws ParkNotFoundException {
        Optional<ParkModel> optionalParkModel = parkRepository.findById(parkId);
        if(optionalParkModel.isEmpty()){
            throw new ParkNotFoundException("Park with id:" +  parkId + "does not exist");
        }
        ParkModel parkModel = optionalParkModel.get();

        return parkModel;
    }


    public void updateParks(ParkModel updatedPark) throws ParkNotFoundException {

        ParkModel existingPark = getParkById(updatedPark.getId());
        existingPark.setName(updatedPark.getName());
        existingPark.setCity(updatedPark.getCity());
        existingPark.setAddress(updatedPark.getAddress());
        parkRepository.save(existingPark);
    }
}

