package telran.io;

import java.util.Arrays;

public class Start {

	public static void main(String[] args) throws Exception{
		if (args.length < 3) {
			throw new Exception("Not enough arguments to start application");
		}
		if (args.length > 5) {
			throw new Exception("Too much arguments to start application");
		}
		try {
			Copy variant = new FilesCopyBuilder().build(args[0], Arrays.copyOfRange(args, 1, args.length));
			variant.copyRun();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
}
