import org.jf.DexLib2Utils;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File file = new File("/Users/milk/Downloads/classes(1).dex");
		DexLib2Utils.saveDex(file, new File(file.getParentFile(), "classes_fix.dex"));
	}
}
