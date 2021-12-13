import com.googlecode.dex2jar.tools.BlackObfuscatorCmd;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Black");

        BlackObfuscatorCmd.main("d2j-black-obfuscator","-d", "1","-i","classes.dex","-o","target.dex","-p","com.pkg");

    }
}
