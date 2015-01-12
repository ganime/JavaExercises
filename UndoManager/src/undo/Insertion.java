package undo;

public class Insertion implements Change {
	private int pos;
	private String s;
	private int oldDot;
	private int newDot;
		
	public Insertion (int pos, String s, int oldDot, int newDot) {
		this.pos = pos;
		this.s = s;
		this.oldDot = oldDot;
		this.newDot = newDot;	
	}
	
	@Override
	public String getType() {
		return "Insert";
	}

	@Override
	public void apply(Document doc) {
		doc.insert(pos, s);
		doc.setDot(this.newDot);
	}

	@Override
	public void revert(Document doc) {
		doc.delete(pos, s);
		doc.setDot(this.oldDot);
	}
	
	@Override
	public String toString() {
		return this.getType() + ": \"" + s + "\"";
	}

}
