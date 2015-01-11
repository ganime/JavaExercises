package undo;

import java.util.Stack;

public class CopyOfUndoManagerImpl implements UndoManager {
	Stack<Change> undoRedoStack = new Stack<Change>();
	private int stackSize;
	private Document doc;
	
	public CopyOfUndoManagerImpl (Document doc, int bufferSize){
		this.stackSize = bufferSize;
		this.doc = doc;
	}

	@Override
	public void registerChange(Change change) {
		if (undoRedoStack.size() == stackSize) {
			undoRedoStack.setElementAt(change, 0);	
		}
		else undoRedoStack.push(change);
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		if (undoRedoStack.size() != 0) {
			Change latestChange = undoRedoStack.pop();
			latestChange.revert(doc);
		}
	}

	@Override
	public boolean canRedo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

}
