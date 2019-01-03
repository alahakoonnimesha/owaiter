package nishi.owaiter3.repository;

import nishi.owaiter3.entity.Table1;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories(basePackages = "nishi.owaiter3.repository")
@SpringBootApplication
public interface TableRepository extends JpaRepository<Table1,Integer> {

   // @Modifying
   // @Query("UPDATE availability OF table1 WHERE tableno:tableno")
    //int updateAvailability(@Param("availability") String availability, @Param("tableno") int tableno);



}
