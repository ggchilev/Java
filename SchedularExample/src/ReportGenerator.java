import java.util.TimerTask;

public class ReportGenerator extends TimerTask {

	public ReportGenerator(){
		super();
	}
	
	FileManager fManager = new FileManager();

	public void run() {
		fManager.saveResult();
	}

}