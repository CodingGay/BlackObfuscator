package top.niunaijun.obfuscator;

import com.googlecode.dex2jar.ir.Trap;
import com.googlecode.dex2jar.ir.stmt.LabelStmt;
import com.googlecode.dex2jar.ir.stmt.Stmt;
import com.googlecode.dex2jar.ir.stmt.Stmts;
import org.objectweb.asm2.Label;

import java.util.ArrayList;
import java.util.List;

public class LBlock {
	private LabelStmt labelStmt;
	private List<Stmt> stmts = new ArrayList<>();
	private String key = "";
	private String nextKey = "";
	private Trap trap;

	public LBlock() {
		this.labelStmt = Stmts.nLabel();
		this.labelStmt.tag = new Label();
	}

	public LBlock(LabelStmt labelStmt) {
		this.labelStmt = labelStmt;
	}

	public LBlock(LabelStmt labelStmt, List<Stmt> stmts) {
		this.labelStmt = labelStmt;
		this.stmts = stmts;
	}

	public LabelStmt getLabelStmt() {
		return labelStmt;
	}

	public void setLabelStmt(LabelStmt labelStmt) {
		this.labelStmt = labelStmt;
	}

	public List<Stmt> getStmts() {
		return stmts;
	}

	public void setStmts(List<Stmt> stmts) {
		this.stmts = stmts;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNextKey() {
		return nextKey;
	}

	public void setNextKey(String nextKey) {
		this.nextKey = nextKey;
	}

	public Trap getTrap() {
		return trap;
	}

	public void setTrap(Trap trap) {
		this.trap = trap;
	}
}
