package Controller;


import DAO.CustomerDAO;
import MODEL.Customer;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CustomerController {
	
	CustomerDAO dao;
	
	public CustomerController(Javalin app) {
		
		dao = new CustomerDAO();
		
		app.get("/users/{username}", getHandler);
		app.post("/users", postHandler);
		app.put("/users/{username}", putHandler);
		app.delete("/users/{username}", deleteHandler);
		
	}
	public Handler getHandler = ctx -> {
		
		//get the paths username
		String username = ctx.pathParam("username");
		
		//get the user based on username
		Customer customer = dao.get(username);
		
		// turns given java object into json format which is a text format understood by almost everyone
		// and can be used in any system running any technology
		ctx.json(customer);
		
		
	};
	public Handler postHandler = ctx -> {
		
		
		//turn the body of the request from JSON (ie text) into a real java object
		Customer customer = ctx.bodyAsClass(Customer.class);
		
		dao.signup(customer);
		//as best practice responses should have descriptive status codes
		ctx.status(201);
	};
	public Handler putHandler = ctx -> {
		Customer customer = ctx.bodyAsClass(Customer.class);
		dao.update(customer);
		ctx.status(200);
	};
	public Handler deleteHandler = ctx -> {
		Customer customer = ctx.bodyAsClass(Customer.class);
		dao.delete(customer);
		ctx.status(200);
	};

}
