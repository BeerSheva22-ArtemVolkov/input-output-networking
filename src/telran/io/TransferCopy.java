package telran.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class TransferCopy extends Copy{

	public TransferCopy(String srcFilePath, String destFilePath, boolean overwrite) {
		super(srcFilePath, destFilePath, overwrite);
	}

	@Override
	protected long copy() throws Exception {
		long res = 0;
		if (Files.exists(Path.of(getDestFilePath())) && isOverwrite() || !Files.exists(Path.of(getDestFilePath())))
			try (InputStream is = new FileInputStream(new File(getSrcFilePath())); OutputStream os = new FileOutputStream(new File(getDestFilePath()))){
				res = is.transferTo(os);
			}
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
