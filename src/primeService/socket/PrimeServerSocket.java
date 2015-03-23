package primeService.socket;

import primeService.socket.PrimeServerWorker;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import primeService.util.Debug;


public class PrimeServerSocket extends Thread{

    private int portNum;
    
    /**
     * toString method describing what PrimeServerSocket is
     * @return string describing the class
     */
    public String toString(){
    	return "This is the thread that runs the Server Socket";
    }
    
    
    /**
     * constructor for PrimeServerSocket
     * @param portNumIn port number on which to connect to the host
     */
    public PrimeServerSocket(int portNumIn){
	portNum = portNumIn;
    }
    
    /**
     * starts the PrimeServerSocket thread
     */
    public void run(){
	Socket clientSocket = null;
        try(ServerSocket serverSocket = new ServerSocket(portNum)){
	    while(true){
		    try{
			clientSocket = serverSocket.accept();
			Debug.printMessage(1, "New client connected");
			PrimeServerWorker worker = new PrimeServerWorker(clientSocket);
			worker.start();
			Debug.printMessage(2, "New thread started: PrimeServerWorker");
		    }
		    catch(IOException e){
			System.err.println("Failed to start socket in PrimeServerSocket");
			System.exit(1);
		    }
	    }
	}
        catch(IOException e){
            System.err.println("Exception from Server Driver");
            System.err.println(e.getMessage());
        }finally{
	    try{
		clientSocket.close();
	    }catch(IOException e){
		System.err.println("Failed to close socket");
		System.exit(1);
	    }
	}
    }   
}
