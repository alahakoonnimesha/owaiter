package nishi.owaiter3.repository;

import nishi.owaiter3.entity.Admin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;

@EnableJpaRepositories(basePackages = "nishi.owaiter3.repository")
@SpringBootApplication
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByEmail(String email);



}

