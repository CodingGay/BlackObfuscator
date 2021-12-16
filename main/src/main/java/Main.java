import com.googlecode.dex2jar.tools.BlackObfuscatorCmd;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Black");
        BlackObfuscatorCmd.main("d2j-black-obfuscator",
                "-d", "2",
                "-i", "/Users/milk/Documents/classes.dex",
                "-o", "/Users/milk/Documents/classes_out.dex",
                "-a", "filter.txt");
    }
}
