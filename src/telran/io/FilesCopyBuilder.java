package telran.io;

import java.io.File;

public class FilesCopyBuilder {

	public Copy build(String type, String[] args) throws Exception {

		Copy res = null;
		String pathFrom = getPathFrom(args);
		String pathTo = getPathTo(args);
		boolean rewrite = needToRewrite(args);

		switch (type) {
		case "FilesCopy":
			res = new FilesCopy(pathFrom, pathTo, rewrite);
			break;
		case "TransferCopy":
			res = new TransferCopy(pathFrom, pathTo, rewrite);
			break;
		case "BufferCopy":
			int bufSize = getBufSize(args);
			res = new BufferCopy(pathFrom, pathTo, rewrite, bufSize);
			break;
		default:
			throw new Exception("Incorrect type");
		}
		return res;
	}

	private static String getPathFrom(String[] args) throws Exception {
		File file = new File(args[0]);
		if (!file.exists() || !file.isFile()) {
			throw new Exception("No path to input file");
		}
		return args[0];
	}

	private static String getPathTo(String[] args) throws Exception {
		File file = new File(args[1]);
		if (!file.isDirectory() && !file.isFile()) {
			throw new Exception("Invalid output path");
		}
		return file.isFile() ? args[1] : args[1] + "\\" + new File(args[0]).getName();
	}

	private static boolean needToRewrite(String[] args) throws Exception {
		String res = args[2];
		if (!res.equalsIgnoreCase("true") && !res.equalsIgnoreCase("false")) {
			throw new Exception("This argument impossible convert to type Boolean");
		}
		return Boolean.parseBoolean(res);
	}

	private static int getBufSize(String[] args) throws Exception {
		if (args.length < 4) {
			throw new Exception("No argument for Buffer Size");
		}
		return Integer.parseInt(args[3]);
	}
}
