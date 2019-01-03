package nishi.owaiter3.repository;

import nishi.owaiter3.entity.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories(basePackages = "nishi.owaiter3.repository")
@SpringBootApplication
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);


    User findById(int id);
}
