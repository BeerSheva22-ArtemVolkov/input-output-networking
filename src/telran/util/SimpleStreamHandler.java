package telran.util;

import java.io.PrintStream;

public class SimpleStreamHandler implements Handler{

	PrintStream stream;
	
	SimpleStreamHandler(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void publish(LoggerRecord loggerRecord) {
		stream.print("<<" + loggerRecord.timestamp + "> " + 
					 "<" +	loggerRecord.zoneID + "> " + 
					 "<" +	loggerRecord.level + "> " + 
					 "<" +	loggerRecord.loggerName + "> " + 
					 "<" +	loggerRecord.message + ">>");
	}
}
