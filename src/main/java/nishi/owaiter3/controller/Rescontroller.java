package nishi.owaiter3.controller;

import nishi.owaiter3.entity.User;
import nishi.owaiter3.repository.UserRepository;
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
@RequestMapping("/users")

public class Rescontroller {


    @Autowired
    private UserRepository urepo;

    /*@GetMapping("/user/{id}")
    public Optional<User> getTable(@PathVariable int id )
    { return urepo.findById(id);}*/

    @GetMapping(value = "/all")
    private List<User>getUsers()
    { return urepo.findAll();}

    @GetMapping("/user/{id}")
    public Optional<User> getTable(@PathVariable("id") int id,@RequestBody User user)
    { return Optional.of((urepo.findById(id)));}


    @GetMapping("/user/{email}")
    public User getUser(@PathVariable("useremail") String email,@RequestBody User user)
    { return urepo.findByEmail(email);}

    //user registration form//
    Map<String,String> errors;


    @PostMapping(value ="/createuser")
    public ResponseEntity<Object> createuser(@RequestBody @Valid User user, BindingResult br)
    {
         if(br.hasErrors())
         {
             errors=new HashMap<>();
             for (FieldError error:br.getFieldErrors())
             {
                 errors.put(error.getField(),error.getDefaultMessage());

             }
             return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
         }
         User u =urepo.findByEmail(user.getEmail());
         if(u!=null)
         {
             return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
         }
        return new ResponseEntity<>(urepo.save(user), HttpStatus.OK);


    }

    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    @PostMapping(value = "/login")
    public ResponseEntity<Object> checkLogin(HttpServletRequest request) {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            ;

            Criteria c = session.createCriteria(User.class);
            Conjunction conjunction = new Conjunction();
            conjunction.add(Restrictions.eq("email", username));
            conjunction.add(Restrictions.eq("password", password));

            c.add(conjunction);

            User admin = (User) c.uniqueResult();
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




