package top.niunaijun.obfuscator;

import com.googlecode.dex2jar.ir.stmt.LabelStmt;
import com.googlecode.dex2jar.ir.stmt.Stmt;
import com.googlecode.dex2jar.ir.stmt.Stmts;
import org.objectweb.asm.Label;

import java.util.ArrayList;
import java.util.List;

public class LBlock {
	private LabelStmt labelStmt;
	private List<Stmt> stmts = new ArrayList<>();

	public LBlock() {
		this.labelStmt = Stmts.nLabel();
		this.labelStmt.tag = new Label();
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
}
