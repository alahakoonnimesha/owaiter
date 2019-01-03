package nishi.owaiter3.repository;

import nishi.owaiter3.entity.Fooditem;
import org.hibernate.sql.Select;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.criteria.From;
import java.util.List;

@EnableJpaRepositories(basePackages = "nishi.owaiter3.repository")
@SpringBootApplication
public interface FooditemRepository extends JpaRepository<Fooditem, Integer> {

    List<Fooditem> findByItemtype(String itemtype);






}