package ro.itschool.carparkapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.itschool.carparkapp.entity.CarModel;
import ro.itschool.carparkapp.entity.ParkModel;

import java.util.List;

@Repository
public interface ParkRepository extends JpaRepository<ParkModel, Integer> {

//    @Query(value = "SELECT * FROM carparkapp.cars WHERE park_id LIKE :%param%", nativeQuery = true)
//    List<CarModel> listByParkId(@Param("param") int param);
}
