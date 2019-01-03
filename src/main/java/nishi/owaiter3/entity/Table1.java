package nishi.owaiter3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="table1")
public class Table1 {

    @Id
    @Column(name = "tableno")
    private int tableno;
    @Column(name = "description")
    private String description;
    @Column(name = "noofseats")
    private int noofseats;
    @Column(name = "availability")
    private String availability;



    public Table1(int tableno, String description, int noofseats, String availability) {
        this.tableno = tableno;
        this.description = description;
        this.noofseats = noofseats;
        this.availability=availability;
    }

    public Table1() {
    }

    public int getTableno() {
        return tableno;
    }

    public void setTableno(int tableno) {
        this.tableno = tableno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoofseats() {
        return noofseats;
    }

    public void setNoofseats(int noofseats) {
        this.noofseats = noofseats;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String  availability) {
        this.availability = availability;
    }
}
