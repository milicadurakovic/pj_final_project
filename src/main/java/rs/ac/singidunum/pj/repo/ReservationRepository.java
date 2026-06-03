package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.pj.entity.Reservation;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findAllByDeletedAtIsNull();

    Optional<Reservation> findOneByReservationIdAndDeletedAtIsNull(Integer id);
}