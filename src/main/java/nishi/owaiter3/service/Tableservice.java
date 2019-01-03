package nishi.owaiter3.service;

import nishi.owaiter3.entity.Table1;
import nishi.owaiter3.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tableservice implements ITableservice{
    @Autowired
    private TableRepository trepo;


    @Override
    public Table1 gettablebyid(int tableno) {
        Table1 obj = trepo.findById(tableno).get();
        return obj;
    }

    @Override
    public boolean addtable(Table1 table) {
        return false;
    }

    @Override
    public void edittablee(Table1 table) {

    }

    @Override
    public void deletetable(int tableno) {

       trepo.delete(gettablebyid(tableno));
    }
}
