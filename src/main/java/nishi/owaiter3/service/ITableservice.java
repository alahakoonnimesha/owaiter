package nishi.owaiter3.service;

import nishi.owaiter3.entity.Table1;

import java.util.List;

public interface ITableservice {

    Table1 gettablebyid(int tableno);
    boolean addtable(Table1 table);
    void edittablee(Table1 table);
    void deletetable(int tableno);
}
