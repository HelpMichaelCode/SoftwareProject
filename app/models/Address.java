package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Address extends Model{
    @Id
    private Long aid;

    @Constraints.Required 
    private String Address;

    @OneToOne
    private List<Employee> emp;

    public Address(){
    }

    public Address(Long aid, String Address){
        this.aid = aid;
        this.Address = Address;
    }

    public Long getAddressID(){
        return aid;
    }
    public void setAddressID(Long aid){
        this.aid = aid;
    }
    public String getAddressName(){
        return Address;
    }
    public void setAddressName(Address add){
        this.Address = Address;
    }

    public List<Employee> getEmp() {
        return emp;
    }
    
    public void setEmp (List<Employee> emp) {
        this.emp = emp;
    }

}