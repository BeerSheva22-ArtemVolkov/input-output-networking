package telran.io;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesCopy extends Copy{
	
	public FilesCopy(String srcFilePath, String destFilePath, boolean overwrite) {
		super(srcFilePath, destFilePath, overwrite);
	}

	@Override
	protected long copy() throws Exception {
		long res = 0;
		Path source = Path.of(srcFilePath);
		Path dest = Path.of(destFilePath);
		if (Files.exists(dest) && overwrite || !Files.exists(dest))
			res = Files.copy(source, new FileOutputStream(new File(destFilePath)));
		return res;
	}

	@Override
	protected DisplayResult getDisplayResult(long copyTime, long fileSize) {
		return new DisplayResult(fileSize, copyTime);
	}

	@Override
	public void copyRun() throws Exception {
		long start = System.currentTimeMillis();
		long fileSize = copy();
		long elapsedTime = System.currentTimeMillis() - start;
		DisplayResult displayRes = new DisplayResult(fileSize, fileSize != 0 ? elapsedTime : 0);
		System.out.println(displayRes.toString());
	}

}
