package telran.util;

import java.time.Instant;

import telran.util.Logger.Level;

public class LoggerRecord {

	final Instant timestamp;
	final String zoneID;
	final Level level;
	final String loggerName;
	final String message;

	LoggerRecord(Instant timestamp, String zoneID, final Level level, final String loggerName, final String message) {
		this.timestamp = timestamp;
		this.zoneID = zoneID;
		this.level = level;
		this.loggerName = loggerName;
		this.message = message;
	}
}
