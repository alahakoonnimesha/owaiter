package nishi.owaiter3.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "findItemByType",
                query = "from Fooditem u where u.itemtype = :itemtype"
        )
})
@Table(name = "fooditem")
public class Fooditem {


    @Id
    @Column(name = "itemno")
    private int itemno;
    @Column(name = "itemname")
    private String itemname;
    @Column(name = "itemtype")
    private long itemtype;
    @Column(name = "price")
    private int price;
    @Column(name = "description")
    private String description;
    @Column(name = "availability")
    private String availability;




    public Fooditem(int itemno, String itemname, long itemtype, int price, String description, String availability ) {
        this.itemno = itemno;
        this.itemname = itemname;
        this.itemtype = itemtype;
        this.price = price;
        this.description = description;
        this.availability = availability;
    }



    public Fooditem() {
    }



    public int getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public long getItemtype() {
        return itemtype;
    }

    public void setItemtype(long itemtype) {
        this.itemtype = itemtype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


}
