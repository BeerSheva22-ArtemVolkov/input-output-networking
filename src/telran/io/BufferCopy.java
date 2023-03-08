package telran.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferCopy extends Copy {

	private long bufferSize;

	public BufferCopy(String srcFilePath, String destFilePath, boolean overwrite, long bufferSize) {
		super(srcFilePath, destFilePath, overwrite);
		this.bufferSize = bufferSize;
	}

	@Override
	protected long copy() throws Exception {
		int res = 0;
		if (Files.exists(Path.of(getDestFilePath())) && isOverwrite() || !Files.exists(Path.of(getDestFilePath())))
			try (InputStream is = new FileInputStream(new File(getSrcFilePath()));
					OutputStream os = new FileOutputStream(new File(getDestFilePath()))) {
				byte[] buffer = new byte[(int) bufferSize];
				int length;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
					res += length;
				}
			}
		return res;
	}

	@Override
	protected DisplayResult getDisplayResult(long copyTime, long fileSize) {
		return new DisplayResultBuffer(fileSize, copyTime, bufferSize);
	}

	@Override
	public void copyRun() throws Exception {
		long start = System.currentTimeMillis();
		long fileSize = copy();
		long elapsedTime = System.currentTimeMillis() - start;
		DisplayResult displayRes = new DisplayResultBuffer(fileSize, fileSize != 0 ? elapsedTime : 0, getBufferSize());
		System.out.println(displayRes.toString());
	}

	public long getBufferSize() {
		return bufferSize;
	}

}
