package undo;

import java.util.LinkedList;
import java.util.ListIterator;

public class UndoManagerImpl implements UndoManager {

	LinkedList<Change> undoRedoBuffer = new LinkedList<Change>();
	ListIterator<Change> listIterator = undoRedoBuffer.listIterator();
	private int bufferSize;
	private Document doc;
	private boolean canUndo = false;
	private boolean canRedo = false;
	
	public UndoManagerImpl (Document doc, int bufferSize){
		this.bufferSize = bufferSize;
		this.doc = doc;
	}

	@Override
	public void registerChange(Change change) {
		if (undoRedoBuffer.size() == bufferSize) {
			undoRedoBuffer.set(0,change);	
		}
		else {
			listIterator.add(change);
		}
		this.canUndo = true;
		this.canRedo = false;
	}

	@Override
	public boolean canUndo() {
		return this.canUndo();
	}

	@Override
	public void undo() {
		if(!canUndo) 
			return;
		if(listIterator.hasPrevious()) {
			Change latestChange = listIterator.previous();
			latestChange.revert(doc);
			this.canRedo = true;
		}
	}

	@Override
	public boolean canRedo() {
		return this.canRedo;
	}

	@Override
	public void redo() {
		if(!canRedo())
			return;
		if(listIterator.hasNext()) {
			Change latestChange = listIterator.next();
			latestChange.apply(doc);
		}
	}

}
