package telran.io;

public abstract class Copy {

	protected String srcFilePath;
	protected String destFilePath;
	protected boolean overwrite;
	
	Copy(String srcFilePath, String destFilePath, boolean overwrite){
		this.destFilePath = destFilePath;
		this.srcFilePath = srcFilePath;
		this.overwrite = overwrite;
	}
	
	abstract long copy() throws Exception;
	
	abstract DisplayResult getDisplayResult(long copyTime, long fileSize);
	
	public abstract void copyRun() throws Exception;

}
