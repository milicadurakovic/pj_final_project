package rs.ac.singidunum.pj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.pj.entity.Reservation;
import rs.ac.singidunum.pj.repo.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;

    public List<Reservation> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Reservation> getById(Integer id) {
        return repository.findOneByReservationIdAndDeletedAtIsNull(id);
    }

    public Reservation create(Reservation entity) {
        Reservation r = new Reservation();

        r.setBookstoreId(entity.getBookstoreId());
        r.setBookName(entity.getBookName());
        r.setCustomerName(entity.getCustomerName());
        r.setStatus(entity.getStatus());

        r.setCreatedAt(LocalDateTime.now());

        return repository.save(r);
    }

    public Reservation update(Integer id, Reservation entity) {
        Reservation r = repository.findOneByReservationIdAndDeletedAtIsNull(id)
                .orElseThrow();

        r.setBookstoreId(entity.getBookstoreId());
        r.setBookName(entity.getBookName());
        r.setCustomerName(entity.getCustomerName());
        r.setStatus(entity.getStatus());

        return repository.save(r);
    }
   

    public void deleteById(Integer id) {
        Reservation r = repository.findOneByReservationIdAndDeletedAtIsNull(id)
                .orElseThrow();

        r.setDeletedAt(LocalDateTime.now());
        repository.save(r);
    }
}