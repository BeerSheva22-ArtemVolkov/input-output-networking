package telran.io.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
public class LineOrientedStreams {

	static final String fileNamePrintStream = "lines-stream.txt";
	static final String fileNamePrintWriter = "lines-writer.txt";
	static final String line = "Hello World";
	static final String helloFileName = "test.txt";
	
	private static final int N_RECORDS = 100_000_000;
	
	
	// В чем разница?
	
	@Disabled
	@Test
	void printStreamTest() throws Exception{
		PrintStream printStream = new PrintStream(fileNamePrintStream);
		IntStream.range(0, N_RECORDS).forEach(printStream::println);
		//printStream.println(line);
	}
	
	@Disabled
	@Test
	void printWriterTest() throws Exception{
		// чтобы поместить информацию из буфера в стрим, нужно стрим закрыть
		// обертка try позволяет записать
		try(PrintWriter printWriter = new PrintWriter(fileNamePrintWriter)){
			IntStream.range(0, N_RECORDS).forEach(printWriter::println);
			//printWriter.println(line);
		}
	}
	
	
	@Test
	void bufferedReaderTest() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(helloFileName));
//		while(true) {
//			String nextLine = reader.readLine();
//			if (nextLine == null) {
//				break;
//			}
//			assertEquals(line, nextLine);
//		}
		
//		или
		
//		reader.lines().forEach((nextLine) -> assertEquals(line, nextLine));
		
//		или
		
//		reader.lines().parallel().forEach((nextLine) -> assertEquals(line, nextLine));
	}
}
