package nishi.owaiter3.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name ="userrole")
public class Role {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "roleid")
    private int roleid;

    @Column(name = "roletype")
    private String roletype;

    public Role(int roleid, String roletype) {
        this.roleid = roleid;
        this.roletype = roletype;
    }

    public Role() {
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }
}
