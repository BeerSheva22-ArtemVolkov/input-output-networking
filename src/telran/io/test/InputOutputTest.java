package telran.io.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.*;

class InputOutputTest {

	private static final int SPACE_COUNT = 5;
	String fileName = "myFile";
	String directoryName = "myDirectory";

	@BeforeEach
	void setUp() throws Exception {
		new File(fileName).delete();
		new File(directoryName).delete();
	}

	@Disabled
	@Test
	void test() throws IOException {
		File f1 = new File(fileName);
		assertTrue(f1.createNewFile());
		File dir1 = new File(directoryName);
		assertTrue(dir1.mkdirs());
		System.out.println(dir1.getAbsolutePath());

	}

	
	@Test
	void printDirectoryFileTest() throws IOException {
		printDirectoryFile("C:\\Users\\art96\\Documents\\Scanned Documents", 0);
	}

	void printDirectoryFile(String path, int maxLevel) throws IOException {
		if (maxLevel < 1)
			maxLevel = Integer.MAX_VALUE;
		printFolders(Path.of(path), 0, maxLevel);
	}

	private void printFolders(Path path, int space, int curLevel) throws IOException {
		System.out.println(" ".repeat(space * SPACE_COUNT) + "<" + path.getFileName() + "> - dir");
		if (--curLevel != 0)
			printFilesFromFolders(path, ++space, curLevel);
	}

	private void printFilesFromFolders(Path path, int space, int curLevel) throws IOException {
		for (Path paths : Files.newDirectoryStream(path)) {
			if (!Files.isDirectory(paths))
				System.out.println(" ".repeat(space * SPACE_COUNT) + "<" + paths.getFileName() + "> - file");
			else
				printFolders(paths, space, curLevel);
		}
	}

	
	@Test
	void printDirectoryFilesTest() {
		printDirectoryFiles("C:\\Users\\art96\\Documents\\Scanned Documents", 3);
	}

	void printDirectoryFiles(String path, int maxLevel) {
		if (maxLevel < 1)
			maxLevel = Integer.MAX_VALUE;
		printFolder(new File(path), 0, maxLevel);
	}

	void printFolder(File dir, int space, int curLevel) {
		System.out.println(" ".repeat(space * SPACE_COUNT) + "<" + dir.getName() + "> - dir");
		if (--curLevel != 0)
			printFilesFromFolder(dir, ++space, curLevel);
	}

	void printFilesFromFolder(File dir, int space, int curLevel) {
		for (File file : dir.listFiles()) {
			if (file.isFile())
				System.out.println(" ".repeat(space * SPACE_COUNT) + "<" + file.getName() + "> - file");
			else
				printFolder(file, space, curLevel);
		}
	}
}

