package nishi.owaiter3.entity;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="user")
public class User {


    @NotNull(message="Please enter your email")
    @Email(message="Invalid email!!")
    @Column(name = "useremail")
    private String email;

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @NotNull(message="Please enter your name")
    @Size(min=2,message="Your name must be wrong")
    @Column(name = "username")
    private String name;



    @NotNull(message="Please enter your phone no")
    @Pattern(regexp = "[\\d]{10}",message="Invalid phone no")
    @Column(name = "phoneno")
    private String phoneno;


    @NotNull(message="Please enter a password")
    @Size(min=6,message="Your password must have atleast 6 characters!!!")
    @Column(name = "password")
    private String password;

    @Column(name ="status")
    private String status;

    public User(int id, String name, String email,String phoneno, String password,String status )
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phoneno = phoneno;
        this.password = password;
        this.status = status;

    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
