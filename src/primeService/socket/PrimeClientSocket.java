package primeService.socket;

import primeService.client.ClientMenu;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class PrimeClientSocket extends Thread{
    private String hostName;
    private int portNum;

    /**
     * toString method describing what PrimeCLientSocket is
     * @return string describing the class
    */
    public String toString(){
    	return "This is the thread that runs the Client Socket";
    }

    /**
     * constructor for PrimeClientSocket
     * @param hostNameIn hostName on which to connect the socket
     * @param portNumIn port number on which to connect to the host
     */
    public PrimeClientSocket(String hostNameIn, int portNumIn){
	hostName = hostNameIn;
	portNum = portNumIn;
    }
    
    /**
     * starts the PrimeCLientSocket thread
     */
    public void run(){

        try(
            Socket clientSocket = new Socket(hostName, portNum);
	    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
	    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    Scanner scan = new Scanner(System.in);
            ){
	    String name = null;
	    int num = 0;
	    while(true){
		int input = ClientMenu.menu();
		switch(input){
		case 1:
		    //set name
		    System.out.println("Enter your name");
		    try{
			name = scan.nextLine();
		    }catch(InputMismatchException e){
			System.err.println("Improper input format");
			System.err.println(e.getMessage());
			System.exit(1);
		    }
		    break;
		case 2:
		    //set prime
		    System.out.println("Enter an integer value to test for prime");
		    try{
			num = scan.nextInt();
		    }catch(InputMismatchException e){
			System.err.println("Improper input format");
			System.err.println(e.getMessage());
			System.exit(1);
		    }
		    break;
		case 3:
		    //call server
		    if(name != null){
			//write to server
			out.println(name + "#" +  num);
			String inputLine;
			while(true){
			    if((inputLine = in.readLine()) != null){
				System.out.println(inputLine);
				break;
			    }
			    else{
				System.err.println("Server disconnected");
				System.exit(1);
			    }
			}
		    }
		    else{
			System.err.println("Please set name and num first");
		    }
		    break;
		default:
		    System.out.println("Please enter valid input 1, 2, 3, or 4");
		}
	    }
		
            }catch(UnknownHostException e){
            System.err.println("Unkown host");
            System.exit(1);
        }catch(IOException e){
            System.err.println("IO Exception");
            System.exit(1);
        }

    }

}
