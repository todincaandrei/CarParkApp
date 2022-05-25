package ro.itschool.carparkapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.carparkapp.entity.ParkModel;
@Repository
public interface ParkRepository extends JpaRepository<ParkModel,Integer> {


}
