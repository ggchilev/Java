
public class WrongDirException extends Exception{

	public WrongDirException(String message,
	         Throwable cause){
		super(message, cause);
	}
	
	public WrongDirException(String message){
		super(message);
	}
}
