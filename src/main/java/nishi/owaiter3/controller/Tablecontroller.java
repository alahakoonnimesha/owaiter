package nishi.owaiter3.controller;


import nishi.owaiter3.entity.Table1;
import nishi.owaiter3.repository.TableRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping("/tables")
public class Tablecontroller {

    @Autowired
    private TableRepository trepo;

    @GetMapping(value = "/all")
    public List<Table1>getTables()
    { return trepo.findAll();}

    @GetMapping("/table/{id}")
    public Optional<Table1> getTable(@PathVariable int id )
    { return trepo.findById(id);}


    private Table1 getTableById(int tableno)
    {
        Table1 obj = trepo.findById(tableno).get();
        return obj;
    }
    @DeleteMapping("/table/{tableno}")
    public ResponseEntity<Void> deleteTable(@PathVariable("tableno") int tableno)
    {
        trepo.delete(getTableById(tableno));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/table")
    public  Table1 editTable(@RequestBody Table1 table)
    {
        Optional<Table1> byId = trepo.findById(1);

        return trepo.save(table);
    }
    @PutMapping("/table/available")
    public  Table1 editTable3(@RequestBody Table1 table)
    {

        return trepo.save(table);
    }


    @PutMapping("/table/t/{tableno}")
    public Table1 updateTable(@PathVariable("tableno") int  tableno,Table1 table)
    {
        getTableById(tableno);
        table.setNoofseats(table.getNoofseats());
        table.setAvailability(table.getAvailability());
        table.setDescription(table.getDescription());

        return trepo.save(table);

    }
    /*@PutMapping("/table/avail")
    public  Table1 editTable2(@RequestBody Table1 table)//,@RequestParam String id)
    {
        Session session=new Configuration().buildSessionFactory().openSession();
        Criteria c=session.createCriteria(Table1.class);
        c.add(Restrictions.eq("tableno",1));

        Table1 t= (Table1) c.uniqueResult();
        if(t!=null){
            t.setAvailability("false");
            session.update(t);
             session.beginTransaction().commit();
        }
        return trepo.save(table);
    }
*/
    @GetMapping("/table")
    public  Table1 addTable(@RequestBody Table1 table,@RequestParam String a)
    {
        System.out.println(a);

        return trepo.save(table);
    }

   /* @PutMapping("/table/changeavail/{tableno}")
    public  ResponseEntity<String> changeAvail()
    {
        return save(updateAvailability(availability,tableno));
    }*/


    @PutMapping("/table/{tableno}")
    public ResponseEntity<Table1> updateTable5(@PathVariable("tableno") int tableno,@RequestBody Table1 table)
    {
        Optional<Table1> data=trepo.findById(tableno);

        if(data.isPresent())
        {
            Table1 table2=data.get();
            table2.setNoofseats(table.getNoofseats());
            table2.setAvailability(table.getAvailability());
            table2.setDescription(table.getDescription());
            return new ResponseEntity<>(trepo.save(table2),HttpStatus.OK);

        }
        else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND );
            }

    }

}
