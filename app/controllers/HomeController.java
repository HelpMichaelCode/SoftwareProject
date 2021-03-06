package controllers;

import play.mvc.*;

import views.html.*;

import play.api.Environment;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import models.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private FormFactory formFactory;

    @Inject
    public HomeController(FormFactory f) {
        this.formFactory = f;
}
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result employees(Long cat) {
        List<Employee> empList = null;
        List<Department> departmentList = Department.findAll();
       
        if(cat ==0){
            empList = Employee.findAll();
        }else {
            empList = Department.find.ref(cat).getEmp();
           
        }
        return ok(employees.render(empList, departmentList));

     }

    public Result home() {
        return ok(home.render());
    }

    public Result about() {
        return ok(about.render());
    }

    public Result addEmp() {
        Form<Employee> employeeForm = formFactory.form(Employee.class);
        return ok(addEmp.render(employeeForm));
}

public Result addEmpSubmit() {
   
    Form<Employee> employeeForm = formFactory.form(Employee.class).bindFromRequest();
    // We check for errors (based on constraints set in Employee class)
    if (employeeForm.hasErrors()) {
        // If the form data have errors, we call the method badRequest(), requesting Play 
        // Framework to send an error response to the user and display the addEmp page again. 
        // As we are passing in employeeForm, the form will be populated with the data that the 
        // user has already entered, saving them from having to enter it all over again.
        return badRequest(addEmp.render(employeeForm));
    } else {
        // If no errors are found in the form data, we extract the data from the form.
        // Form objects have handy utility methods, such as the get() method we are using 
        // here to extract the data into an Employee object. This is possible because
        // we defined the form in terms of the model class Employee.
        Employee newEmp = employeeForm.get();

        if(newEmp.getId()==null){
            newEmp.save();
        }else{
            newEmp.update();
        }
        // We use the flash scope to specify that we want a success message superimposed on
        // the next displayed page. The flash scope uses cookies, which we can read and set
        // using the flash() function of the Play Framework. The flash scope cookies last
        // for a single request (unlike session cookies, which we will use for log-in in a
        // future lab). So, add a success message to the flash scope.
        flash("success", "" + newEmp.getFname() + " " + newEmp.getLname() + " was added/updated.");
        // Having specified we want a message at the top, we can redirect to the onsale page,
        // which will have to be modified to read the flash scope and display it.
        return redirect(controllers.routes.HomeController.employees(0));
    }
}

public Result deleteEmp(Long id) {

    
    Employee.find.ref(id).delete();

   
    flash("success", "Employee has been deleted.");
    // And redirect to the onsale page
    return redirect(controllers.routes.HomeController.employees(0));
}

public Result updateEmp(Long id) {
    Employee i;
    Form<Employee> employeeForm;

    try {
       
        i = Employee.find.byId(id);

        
        employeeForm = formFactory.form(Employee.class).fill(i);
    } catch (Exception ex) {
        return badRequest("error");
    }

    return ok(addEmp.render(employeeForm));
}

}
