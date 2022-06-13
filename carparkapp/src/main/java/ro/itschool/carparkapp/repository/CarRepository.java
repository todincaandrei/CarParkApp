package ro.itschool.carparkapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.itschool.carparkapp.entity.CarModel;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Integer> {


    @Query(value = "SELECT * FROM carparkapp.cars WHERE model LIKE %:param%", nativeQuery = true)
    List<CarModel> searchByModel(@Param("param") String param);


}
