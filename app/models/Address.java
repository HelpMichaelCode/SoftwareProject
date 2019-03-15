package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Address extends Model{
    @Id
    private Long id;

    @Constraints.Required 
    private String Address;

    @OneToOne
    private Employee employee;

    public Address(){
    }

    public Address(Long id, String Address){
        this.id = id;
        this.Address = Address;
    }

    public Long getAddressID(){
        return id;
    }
    public void setAddressID(Long id){
        this.id = id;
    }
    public String getAddressName(){
        return Address;
    }
    public void setAddressName(String Address){
        this.Address = Address;
    }

    public Employe getEmp() {
        return employee;
    }
    
    public void setEmp (Employee emp) {
        this.emp = emp;
    }

}