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
		if (Files.exists(Path.of(destFilePath)) && overwrite || !Files.exists(Path.of(destFilePath)))
			try (InputStream is = new FileInputStream(new File(srcFilePath)); OutputStream os = new FileOutputStream(new File(destFilePath))){
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
