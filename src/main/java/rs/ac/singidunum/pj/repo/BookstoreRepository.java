package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.pj.entity.Bookstore;

@Repository
public interface BookstoreRepository  extends JpaRepository<Bookstore, Integer> {

}
