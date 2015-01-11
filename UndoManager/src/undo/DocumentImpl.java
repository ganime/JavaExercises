package undo;

public class DocumentImpl implements Document {
	StringBuilder content = new StringBuilder();
	int dot = 0;

	@Override
	public void delete(int pos, String s) {
		if (pos < 0 || pos > content.length()) return;
		
	    String subs = content.substring(pos, pos + s.length());
	    if (!subs.equals(s)) return;
	    
		content.replace(pos, pos + s.length(), "");
		setDot(pos);
	}

	@Override
	public void insert(int pos, String s) {
		if (pos < 0 || pos > content.length()) return;
		content.insert(pos, s);
		setDot(pos + s.length());
	}

	@Override
	public void setDot(int pos) {
		this.dot = pos;
	}
	
	public void print() {
		System.out.println("Document:" + content.toString());
	}

}
