package telran.io;

public abstract class Copy {

	private String srcFilePath;
	private String destFilePath;
	private boolean overwrite;
	
	Copy(String srcFilePath, String destFilePath, boolean overwrite){
		this.destFilePath = destFilePath;
		this.srcFilePath = srcFilePath;
		this.overwrite = overwrite;
	}
	
	protected abstract long copy() throws Exception;
	
	protected abstract DisplayResult getDisplayResult(long copyTime, long fileSize);
	
	public abstract void copyRun() throws Exception;

	public String getSrcFilePath() {
		return srcFilePath;
	}

	public String getDestFilePath() {
		return destFilePath;
	}

	public boolean isOverwrite() {
		return overwrite;
	}
}
