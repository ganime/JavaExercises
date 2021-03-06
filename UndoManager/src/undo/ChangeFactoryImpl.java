package undo;

//This class can be injected as a singleton
public class ChangeFactoryImpl implements ChangeFactory {
	@Override
	public Change createInsertion(int pos, String s, int oldDot, int newDot) {
		return new Insertion(pos, s, oldDot, newDot);
	}

	@Override
	public Change createDeletion(int pos, String s, int oldDot, int newDot) {
		return new Deletion(pos, s, oldDot, newDot);
	}

}
