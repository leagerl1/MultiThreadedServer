package primeService.util;

public class Debug{
    private volatile static Debug debugger = null;
    private static int debugVal;
    
    /**
     * returns toString method of Debug
     * @return Prints description of the class
    */
    public String toString(){
    	return "This is the debugger class which contains a print method to print debug messages based on value";
    }

    /** Static method to set the debugVal */
    public static void setDebugVal(int val){
	debugVal = val;
    }
    
    /**
     * Private constructor 
    */
    private Debug(){
    }

    /** 
     * Static method returns an instance of Debug class. Creates instance if none exists otherwise returns already existing one
     * @return instance of Debug
    */
    public static Debug getInstance(){
	if(debugger == null){
	    synchronized(Debug.class){
		if(debugger == null){
		    debugger = new Debug();
		}
	    }
	}
	return debugger;
    }


    public static void printMessage(int num, String message){
	if(num == debugVal){
	    System.out.println(message);
	}
    }
}
