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
    private Category category;

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
    public String getFirstName() {
        return this.fname;
    }
    public void setFirstName(String fname) {
        this.fname = fname;
    }
    public String getLastName() {
        return this.lname;
    }
    public void setLastName(String lname) {
        this.lname = lname;
    }
    

public Category getCategory() {
    return category;
}
public void setCategory(Category category) {
    this.category = category;
}
}