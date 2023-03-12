package telran.io;

import java.util.Arrays;

public class Start {

	public static void main(String[] args) {
		try {
			Copy variant = new FilesCopyBuilder().build(args[0], Arrays.copyOfRange(args, 1, args.length));
			variant.copyRun();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
}
