package undo;

import java.util.LinkedList;

public class UndoManagerImpl implements UndoManager {

	LinkedList<Change> undoRedoBuffer = new LinkedList<Change>();
	private int bufferSize;
	private Document doc;
	private boolean canUndo = false;
	private boolean canRedo = false;
	int pointer = 0;
	
	public UndoManagerImpl (Document doc, int bufferSize){
		this.bufferSize = bufferSize;
		this.doc = doc;
	}

	@Override
	public void registerChange(Change change) {
		if (undoRedoBuffer.size() == bufferSize) {
			undoRedoBuffer.removeLast();
		}
		//always add to the top of the list
		undoRedoBuffer.add(0, change);
		//last change is always at the top of the list
		pointer = 0;
		
		this.canUndo = true;
		this.canRedo = false;
		printStack();
	}

	@Override
	public boolean canUndo() {
		return this.canUndo();
	}

	@Override
	public void undo() {
		if(!canUndo) 
			throw new IllegalStateException();		
		Change latestChange = undoRedoBuffer.get(pointer);
		latestChange.revert(doc);
		pointer++;
		this.canRedo = true;
	}

	@Override
	public boolean canRedo() {
		return this.canRedo;
	}

	@Override
	public void redo() {
		if(!canRedo())
			throw new IllegalStateException();
		Change latestChange = undoRedoBuffer.get(--pointer);
		latestChange.apply(doc);
	}

	public void printStack() {
		System.out.println("------------------");
		System.out.println("UndoRedoBuffer:");
		for (Change  change : undoRedoBuffer) {
			System.out.println(change.toString());
		}
		System.out.println("------------------");
	}
}
