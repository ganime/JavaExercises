package undo;

public class UndoManagerFactoryImpl implements UndoManagerFactory {

	@Override
	public UndoManager createUndoManager(Document doc, int bufferSize) {
		return new UndoManagerImpl(doc, bufferSize);
	}

}
