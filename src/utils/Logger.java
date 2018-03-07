package utils;

public class Logger {
	
	private static Logger logger = new Logger();
	private boolean isLogging = false;
	
	private Logger() {
	}
	
	public static Logger getInstance() {
		return logger;
	}
	
	public void log(String messagem) {
		if (this.isLogging ) {
			System.out.println(messagem);
		}
	}

	public void startLogger() {
		this.isLogging = true;
	}

	public void stopLogger() {
		this.isLogging = false;
	}

}
