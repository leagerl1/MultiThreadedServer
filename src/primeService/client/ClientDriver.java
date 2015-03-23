package primeService.client;


import primeService.socket.PrimeClientSocket;
import java.util.Scanner;
import primeService.util.Debug;

public class ClientDriver{

    /**
     * toString method of client driver
     * @return string describing what class does 
     */
    public String toString(){
    	return "Driver class for calling Client in main method driver";
    }

    /** method that starts up the client in a new thread
     * @param hostName string representing name of host to run client on
     * @param portNum integer representing the port num the server should run on
     */ 
    public void start(String hostName, int portNum){
		PrimeClientSocket clientSocket = new PrimeClientSocket(hostName, portNum);
		clientSocket.start();
		Debug.printMessage(2, "New thread started: ClientSocket");
    }
}
