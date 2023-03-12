package telran.util;

import java.time.*;
import java.util.logging.Level;

public class Logger {

	enum Level {
		TRACE, DEBUG, INFO, WARN, ERROR
	}

	Level level;
	Handler handler;
	String name;
	
	Logger(Handler handler, String name) {
		this.handler = handler;
		this.name = name;
	}

	void setLevel() {
		level = Level.INFO;
	}

	void setLevel(Level level) {
		this.level = level;
	}

	void error(String message) {
		sendToPublish(Level.ERROR, message);	
	}

	void warn(String message) {
		sendToPublish(Level.WARN, message);
	}

	void info(String message) {
		sendToPublish(Level.INFO, message);
	}

	void debug(String message) {
		sendToPublish(Level.DEBUG, message);
	}

	void trace(String message) {
		sendToPublish(Level.TRACE, message);
	}
	
	private void sendToPublish(Level level, String message) {
		handler.publish(new LoggerRecord(Instant.now(), ZoneId.systemDefault().getId(), level, name, message));
	}
}
