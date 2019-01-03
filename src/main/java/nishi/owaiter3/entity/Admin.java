package nishi.owaiter3.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin{

    @NotNull(message="Please enter your email")
    @Email(message="Invalid email!!")
    @Column(name = "email")
    private String email;

    @Id
    @Column(name = "id")
    private int id;


    @NotNull(message="Please enter your name")
    @Size(min=2,message="Your name must be wrong")
    @Column(name = "name")
    private String name;



    @NotNull(message="Please enter a password")
    @Size(min=6,message="Your password must have atleast 6 characters!!!")
    @Column(name = "password")
    private String password;



    public Admin(String email, int id, String name, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Admin() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


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


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


}
