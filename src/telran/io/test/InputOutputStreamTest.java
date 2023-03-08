package telran.io.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class InputOutputStreamTest {

	final static String fileName = "test.txt";
	final static String fileNameCopy = "test2.txt";
	String hello = "Hello World";
	
	@BeforeAll
	static void setUp() throws Exception {
		Files.deleteIfExists(Path.of(fileName));
	}

	@Order(1)
	@Test
	void OutputStreamTest() throws Exception { 
		try(OutputStream output = new FileOutputStream(fileName)){
			byte[] helloBytes = hello.getBytes();
			output.write(helloBytes);
		}
	}

	
	@Test
	void InputStreamTest() throws Exception {
		String file = fileName;
		readFileTest(file);
	}

	private void readFileTest(String file) throws Exception{
		try(InputStream input = new FileInputStream(file)){
			byte[] buffer = input.readAllBytes();
			String str = new String(buffer);
			assertEquals(hello, str);
		}
	}
	
	@Order(2)
	@Test
	void transferFileToTest() throws Exception {
		try(InputStream input = new FileInputStream(fileName); 
			OutputStream output = new FileOutputStream(fileNameCopy)){
			input.transferTo(output);
		}
	}
	
	@Test
	void copyTest() throws Exception {
		String file = fileNameCopy;
		readFileTest(file);
	}
	
	// HW копия файлов (количество байтов и время в миллесекундах)
	// 1. TransferTo
	// 2. Files.Copy
	// 3. Аругмент с размером буфера (пример 1мб, 10мб, 100мб, 200мб, runtime.freememory)
	// Использовать read (возвращает количество прочитаных байт)
	// Аргументы 
	// 1. путь из
	// 2. путь в
	// 3. можно ли файл перезаписывать
	// 4. раземер буфера
}
