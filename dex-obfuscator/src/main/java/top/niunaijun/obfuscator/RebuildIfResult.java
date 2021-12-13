package top.niunaijun.obfuscator;

import com.googlecode.dex2jar.ir.stmt.Stmt;

import java.util.List;

public class RebuildIfResult {
	private List<Stmt> result;

	public RebuildIfResult(List<Stmt> result) {
		this.result = result;
	}

	public List<Stmt> getResult() {
		return result;
	}

	public void setResult(List<Stmt> result) {
		this.result = result;
	}
}
