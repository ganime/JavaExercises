package undo;

public class Deletion implements Change {

	@Override
	public String getType() {
		return "Delete";
	}

	@Override
	public void apply(Document doc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void revert(Document doc) {
		// TODO Auto-generated method stub

	}

}
