package telran.io;

public class DisplayResult {

	protected long fileSize;
	protected long copyTime;
	
	public DisplayResult(long fileSize, long copyTime){
		this.copyTime = copyTime;
		this.fileSize = fileSize;
	}
	
	public String toString() {
		return 	"Size of copied file : " + fileSize + "\n" +
				"Time of copying : " + copyTime;
	}

}
