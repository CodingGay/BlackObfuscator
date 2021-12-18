package top.niunaijun.obfuscator;

public abstract class ObfuscatorConfiguration {

	/**
	 * 混淆深度
	 */
	protected int getObfDepth() {
		return 1;
	}

	/**
	 * 是否处理此method
	 * @param className className
	 * @param methodName methodName
	 */
	protected boolean accept(String className, String methodName){
		return true;
	}
}
