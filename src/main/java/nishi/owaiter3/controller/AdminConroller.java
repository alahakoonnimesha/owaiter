package nishi.owaiter3.controller;

import com.fasterxml.classmate.AnnotationConfiguration;
import nishi.owaiter3.entity.Admin;
import nishi.owaiter3.repository.AdminRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping("/admins")
public class AdminConroller {

    @Autowired
    private AdminRepository arepo;

    @GetMapping(value = "/all")
    private List<Admin> getAdmins() {
        return arepo.findAll();
    }

    //user registration form//
    Map<String, String> errors;

    @PostMapping(value = "/createadmin")
    public ResponseEntity<Object> createadmin(@RequestBody @Valid Admin admin, BindingResult br) {
        if (br.hasErrors()) {
            errors = new HashMap<>();
            for (FieldError error : br.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());

            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Optional<Admin> u = arepo.findById(admin.getId());
        if (u != null) {
            return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(arepo.save(admin), HttpStatus.OK);


    }

    private Admin getAdminById(int id) {
        Admin obj = arepo.findById(id).get();
        return obj;
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id") int id) {
        arepo.delete(getAdminById(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id,@RequestBody Admin admin) {
        Optional<Admin> data = arepo.findById(id);

        if (data.isPresent()) {
            Admin admin1=data.get();
            admin.setId(admin.getId());
            admin.setEmail(admin.getEmail());
            admin.setName(admin.getName());
            return new ResponseEntity<>(arepo.save(admin), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
        //@RequestMapping(value = "/login",method = RequestMethod.POST)
    @PostMapping(value = "/login")
    public ResponseEntity<Object> checkLogin(HttpServletRequest request) {
        String eid = request.getParameter("id");
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            ;

            Criteria c = session.createCriteria(Admin.class);
            Conjunction conjunction = new Conjunction();
            conjunction.add(Restrictions.eq("id", Integer.parseInt(eid)));
            conjunction.add(Restrictions.eq("email", username));
            conjunction.add(Restrictions.eq("password", password));

            c.add(conjunction);

            Admin admin = (Admin) c.uniqueResult();
            if (admin != null) {

                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("LOG_USER", admin);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }


        } catch (Exception e) {



        }
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);


    }



}
