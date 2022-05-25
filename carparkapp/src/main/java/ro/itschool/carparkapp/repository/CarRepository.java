package ro.itschool.carparkapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.carparkapp.entity.CarModel;
@Repository
public interface CarRepository extends JpaRepository<CarModel, Integer> {



}
