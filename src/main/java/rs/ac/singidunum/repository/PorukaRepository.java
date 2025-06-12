package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.entity.Poruka;

public interface PorukaRepository extends JpaRepository<Poruka, Integer> {
}