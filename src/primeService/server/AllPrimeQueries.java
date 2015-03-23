package primeService.server;

import java.util.concurrent.ConcurrentHashMap;

public class AllPrimeQueries{
    private volatile static AllPrimeQueries APQ = null;
    private ConcurrentHashMap<String, Integer> clientQueries;

    /**
     * returns the clientQueries hash map in string format
     * @return stringifyed clientQueries HashMap
    */
    public String toString(){
    	return clientQueries.toString();
    }

    /**
     * Private constructor initializes ConcurrentHashMap
    */
    private AllPrimeQueries(){
	    this.clientQueries = new ConcurrentHashMap<String,Integer>();
    }

    /** 
     * Static method returns an instance of AllPrimeQuery class. Creates instance if none exists otherwise returns already existing one
     * @return instance of AllPrimeQueries
    */
    public static AllPrimeQueries getInstance(){
		if(APQ == null){
	    	synchronized(AllPrimeQueries.class){
				if(APQ == null){
		    		APQ = new AllPrimeQueries();
				}
	    	}
		}
		return APQ;
    }

    /**
	 * Adds a client name and integer to the clientQueries hashmap
    */
    public void addClient(String name, int num){
		clientQueries.put(name, num);
    }

    /**
	 * prints all the clients in clientQueries to standard out if any exist
    */
    public void printClients(){
		if(clientQueries.isEmpty()){
	    	System.out.println("No clients have connected yet");
		}
		else{
	    	for(String name : clientQueries.keySet()){
				System.out.println(name + " " + clientQueries.get(name));
	    	}
		}
    }

    /**
	 * Prints the name and integer value of a specific client given their name if they exist
	 * @param clientName name of client to search for
    */
    public void printClient(String clientName){
		if(clientQueries.isEmpty()){
	    	System.out.println("No clients have connected yet");
		}
		else{
	    	if(clientQueries.get(clientName) != null){
				int num = clientQueries.get(clientName);
				System.out.println(clientName + " " + num);
	    	}
	    	else{
				System.out.println("No client with that name has connected");
	    	}
		}
    }
}
