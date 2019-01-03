package nishi.owaiter3.repository;

import nishi.owaiter3.entity.Fooditem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemtypeRepository extends JpaRepository<Fooditem,String> {

    public List<Fooditem> findAll();

}
