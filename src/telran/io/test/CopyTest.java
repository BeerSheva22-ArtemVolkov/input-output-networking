package telran.io.test;

import org.junit.jupiter.api.*;
import telran.io.*;

class CopyTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Disabled
	@Test
	void test1() throws Exception {
		Copy copy1 = new FilesCopy("C:\\Users\\art96\\Desktop\\Новая_папка\\From\\mp.mp3", "C:\\Users\\art96\\Desktop\\Новая_папка\\To\\new_mp.mp3", false);
		copy1.copyRun();
	}

	@Disabled
	@Test
	void test2() throws Exception {
		Copy copy2 = new TransferCopy("C:\\Users\\art96\\Desktop\\Новая_папка\\From\\mp.mp3", "C:\\Users\\art96\\Desktop\\Новая_папка\\To\\new_mp.mp3", true);
		copy2.copyRun();
	}
	
	@Disabled
	@Test
	void test3() throws Exception {
		Copy copy3 = new BufferCopy("C:\\Users\\art96\\Desktop\\Новая_папка\\From\\mp.mp3", "C:\\Users\\art96\\Desktop\\Новая_папка\\To\\new_mp.mp3", true, 1000);
		copy3.copyRun();
	}
	
	@Test
	void test4() {
		String s1="true";  
		String s2="TRue";  
		String s3="ok";  
		String s4="false"; 
		boolean b1=Boolean.parseBoolean(s1);  
		boolean b2=Boolean.parseBoolean(s2);  
		boolean b3=Boolean.parseBoolean(s3);  
		boolean b4=Boolean.parseBoolean(s4);  
		System.out.println(b1);  
		System.out.println(b2);  
		System.out.println(b3);  
		System.out.println(b4);  
	}
}
