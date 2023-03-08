package telran.io;

public class DisplayResult {

	private long fileSize;
	private long copyTime;
	
	public DisplayResult(long fileSize, long copyTime){
		this.copyTime = copyTime;
		this.fileSize = fileSize;
	}
	
	public String toString() {
		return 	"Size of copied file : " + fileSize + "\n" +
				"Time of copying : " + copyTime;
	}

	public long getFileSize() {
		return fileSize;
	}

	public long getCopyTime() {
		return copyTime;
	}
}
