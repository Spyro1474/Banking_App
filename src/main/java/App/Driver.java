package App;


import Controller.CustomerController;
import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(7070);
		
		CustomerController userController = new CustomerController(app);
		
		

	}

}