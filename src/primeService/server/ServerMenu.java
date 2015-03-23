package primeService.server;

import java.util.Scanner;

public class ServerMenu{

	/**
	 *	toString method of ServerMenu 
	 *	@return String explaining what this method contains
	*/
	public String toString(){
		return "This class contains a static method menu() which returns the specified menu option from the user";
	}

	/**
	 *	menu method that takes input from user via scan then returns corresponding number of option selected or exits of 3
	 *	@return int value of option selected
	*/
    public static int menu(){
	Scanner scan = new Scanner(System.in);
	System.out.println("Please enter an option:\n1) Client Name\n2) All Clients\n3) Quit\n");
	int input = scan.nextInt();
	switch(input){
	case 1:
	    //Client Name
	    return 1;
	case 2:
	    // Print all clients
	    return 2;
	case 3:
	    System.exit(0);
	}
	return 0;
    }
}