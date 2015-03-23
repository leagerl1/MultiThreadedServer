package primeService.driver;
import primeService.server.ServerDriver;
import primeService.client.ClientDriver;
import primeService.util.Debug;

public class PrimeDriver{

    /**
     * Main method that runs the client or server based on command line input
     */
    public static void main(String[] args){
	if(args[0].equals("Server")){
	    if(args.length < 3){
		System.err.println("ant -buildfile build.xml -Darg0=Server -Darg1=<portNum> -Darg2=<debugVal> run");
		System.exit(1);
	    }
	    ServerDriver s = new ServerDriver();
	    Debug debugger = Debug.getInstance();
	    int debugVal;
	    int portNum;
	    try{
                portNum = Integer.parseInt(args[1]);
		debugVal = Integer.parseInt(args[2]);
		debugger.setDebugVal(debugVal);
		s.start(portNum);
            }catch(NumberFormatException e){
                System.err.println("Argument error");
		System.err.println(e.getMessage());
                System.exit(1);
            }
	}
	else{
	    if(args.length < 4){
		System.err.println("ant -buildfile build.xml -Darg0=Client -Darg1=<hostname> -Darg2=<portNum> -Darg3=<dbugVal> run");
		System.exit(1);
	    }
	    ClientDriver c = new ClientDriver();
	    Debug debugger = Debug.getInstance();
	    int portNum;
	    int debugVal;
	    try{
		portNum = Integer.parseInt(args[2]);
		debugVal = Integer.parseInt(args[3]);
		c.start(args[1], portNum);
		debugger.setDebugVal(debugVal);
	    }catch(NumberFormatException e){
		System.err.println("Argument error");
		System.exit(1);
	    }
	}
    }
}
