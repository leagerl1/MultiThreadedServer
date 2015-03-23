package primeService.server;

import java.util.Scanner;
import primeService.socket.PrimeServerSocket;
import primeService.server.ServerMenu;
import primeService.server.AllPrimeQueries;
import primeService.util.Debug;

public class ServerDriver{
    
    /**toString method of server driver
     * @return string describing what class does 
     */
    public String toString(){
    	return "Driver class for calling Server in main method driver";
    }

    /** method that starts up the server in a new thread
     * @param portNum integer representing the port num the server should run on
     */ 
    public void start(int portNum){
	
	PrimeServerSocket serverSocket = new PrimeServerSocket(portNum);
	serverSocket.start();
	Debug.printMessage(2, "New thread created: ServerSocket");

	AllPrimeQueries APQ = AllPrimeQueries.getInstance();
	while(true){
	    int input = ServerMenu.menu();
	    if(input == 1){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a client name");
		String name = in.nextLine();
		APQ.printClient(name);
	    }
	    else if(input == 2){
		APQ.printClients();
	    }
	    else{
		System.out.println("Please provide valid input 1, 2, or 3");
	    }
	}
    }
}
