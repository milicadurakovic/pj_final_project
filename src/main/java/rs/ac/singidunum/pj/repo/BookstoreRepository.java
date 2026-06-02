package rs.ac.singidunum.pj.repo;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.pj.entity.Bookstore;

@Repository
public interface BookstoreRepository  extends JpaRepository<Bookstore, Integer> {


    List<Bookstore> findAllByDeletedAtIsNull();
    Optional<Bookstore> findOneByBookstoreIdAndDeletedAtIsNull(Integer id);

}
