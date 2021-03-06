package primeService.socket;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import primeService.server.ServerMenu;
import primeService.server.AllPrimeQueries;
import primeService.util.CheckPrime;

public class PrimeServerWorker extends Thread{

    private Socket clientSocket = null;
   
    /**
     * returns the description of the PrimeServerWorkerClass
     * @return string describing the class
     */
    public String toString(){
	return "This class runs the thread for server side socket interactions";
    } 
    
    /**
     * constructor for PrimeServerWorker
     * @param clientSocketIn socket object for the worker to read and write to
     */
    public PrimeServerWorker(Socket clientSocketIn){
	clientSocket = clientSocketIn;
    }
    
    /**
     * runs the PrimeServerWorker thread and handles all the input and output to the socket from the server
    */
    public void run(){
	try(
	    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    ){
	    AllPrimeQueries APQ  = AllPrimeQueries.getInstance();
	    String inputLine;
	    while((inputLine = in.readLine()) != null){
		String input[] = inputLine.split("#");
		String name = input[0];
		try{
		    int num = Integer.parseInt(input[1]);
		    APQ.addClient(name,num);
		    String answer = CheckPrime.isPrime(num);
		    out.println(answer);
		}catch(NumberFormatException e){
		    System.err.println("You must provide a number");
		    System.err.println(e.getMessage());
		    System.exit(1);
		}
	    }
	}catch(IOException e){
	    System.err.println("IOException in PrimeServerWorker");
	    System.err.println(e.getMessage());
	    System.exit(1);
	}
    }
}
