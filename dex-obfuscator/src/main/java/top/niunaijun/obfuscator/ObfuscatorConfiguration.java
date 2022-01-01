package top.niunaijun.obfuscator;

public abstract class ObfuscatorConfiguration {

	/**
	 * 混淆深度
	 */
	public int getObfDepth() {
		return 1;
	}

	/**
	 * 是否处理此method
	 * @param className className
	 * @param methodName methodName
	 */
	public boolean accept(String className, String methodName) {
		return true;
	}
}
