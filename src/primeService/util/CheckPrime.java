package primeService.util;
public class CheckPrime{

    /**
     * toString method describing CheckPrime class
     * @return string describing helpermethod 
     */
    public String toString(){
	return "Class containing static helper method to test for prime";
    }
    
    /** returns a string describing if the given number was prime, not prime, or invalid
     *	@param num integer to test for prime
     */
    public static String isPrime(int num){
	if(num < 3){
	    return "Not Valid input";
	}
	else{
	    if(num % 2 == 0){
		return "Not Prime";
	    }
	    for(int i = 4; i < num; i++){
		if(num % i == 0){
		    return "Not Prime";
		}
	    }
	    return "Prime";
	}
    }
}
