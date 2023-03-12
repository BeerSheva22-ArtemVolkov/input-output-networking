package telran.util;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Logger.Level;

class LoggerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void LOGToOutputFileTest() throws FileNotFoundException {
		Handler handler = new SimpleStreamHandler(new PrintStream("LOG.txt"));
		Logger LOG = new Logger(handler, "fileLOG");
		LOG.setLevel(Level.INFO);
		LOG.info("info msg");
	
	}

	@Test
	void LOGToSystemOutTest() throws FileNotFoundException {
		Handler handler = new SimpleStreamHandler(new PrintStream(System.out));
		Logger LOG = new Logger(handler, "consoleLOG");
		LOG.setLevel(Level.ERROR);
		LOG.error("error msg");
	
	}
}
