package models;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Employee extends Model {

    // Properties
    @Id
    private Long id;

    @Constraints.Required
    private String fname;
    
    @Constraints.Required
    private String lname;
    
    

    @ManyToOne
    private Department department;

    @OneToOne
    private Address address;

    // Default Constructor
    public Employee() {
    }

    // Constructor to initialise object 
    public Employee(Long id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
       
 
    }

    public static final Finder<Long, Employee> find = new Finder<>(Employee.class);
			    
public static final List<Employee> findAll() {
   return Employee.find.all();
}

    // Accessor methods
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFname() {
        return this.fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return this.lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
     public Address getAddress(){
        return address;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    

public Department getDepartment() {
    return department;
}
public void setDepartment(Department department) {
    this.department = department;
}
}