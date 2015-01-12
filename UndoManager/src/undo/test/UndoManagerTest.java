package undo.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import undo.Change;
import undo.ChangeFactory;
import undo.ChangeFactoryImpl;
import undo.Document;
import undo.DocumentImpl;
import undo.UndoManager;
import undo.UndoManagerFactory;
import undo.UndoManagerFactoryImpl;

public class UndoManagerTest extends TestCase{
    Change c1;
    Change c2;
    Change c3;
    Change c4;
    Change c5;

    UndoManagerFactory undoManagerFactory;
    DocumentImpl doc;
    
    @Override
    public void setUp() {
		undoManagerFactory = new UndoManagerFactoryImpl();
		
		ChangeFactory changeFactory = new ChangeFactoryImpl();
		c1 = changeFactory.createInsertion(0, "Hello", 0, "Hello".length());
		c2 = changeFactory.createInsertion(5, ",", 0, ",".length());
		c3 = changeFactory.createInsertion(6, "world", 0, "world".length());
		c4 = changeFactory.createDeletion(0, "Hello", 0, 0);
   }

    @Test
    public void testBufferCreation() {
		UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 3);

        assertEquals(3, undoManager.bufferCapacity());
        assertEquals(0, undoManager.bufferSize());
    }
   
    @Test
    public void testBufferAdd() {
    	Document doc = new DocumentImpl();
		UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 3);
		undoManager.registerChange(c1);
        assertEquals(1, undoManager.bufferSize());

		undoManager.registerChange(c2);
        assertEquals(2, undoManager.bufferSize());

		undoManager.registerChange(c3);
        assertEquals(3, undoManager.bufferSize());
        
		undoManager.registerChange(c4);
        assertEquals(3, undoManager.bufferSize());
   }

    @Test
    public void testInsertion() {
    	Document doc = new DocumentImpl();
		UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 3);
		undoManager.registerChange(c1);
		c1.apply(doc);
        assertEquals(doc.getContent(), "Hello");

		undoManager.registerChange(c2);
		c2.apply(doc);
        assertEquals(doc.getContent(), "Hello,");

    	undoManager.registerChange(c3);
		c3.apply(doc);
        assertEquals(doc.getContent(), "Hello,world");
        
        System.out.println(undoManager);
   }

    @Test
    public void testUndoSingleItem() {
    	Document doc = new DocumentImpl();
		UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 3);
		undoManager.registerChange(c1);
		c1.apply(doc);
		
		Change u1 = undoManager.currentChange();
		assertEquals(c1, u1);
		undoManager.undo();

        Change u2 = undoManager.currentChange();
        Assert.assertNull(u2);
}

   
	    @Test
	    public void testUndoMultipleItems() {
	    	Document doc = new DocumentImpl();
			UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 3);
			undoManager.registerChange(c1);
			c1.apply(doc);

			undoManager.registerChange(c2);
			c2.apply(doc);

			Change u2 = undoManager.currentChange();
			assertEquals(c2, u2);
			undoManager.undo();

			Change u1= undoManager.currentChange();
			assertEquals(c1, u1);
			undoManager.undo();

	        Change u3 = undoManager.currentChange();
	        Assert.assertNull(u3);
	    }

	    @Test
	    public void testRedoSingleItem() {
	    	Document doc = new DocumentImpl();
			UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 3);
			undoManager.registerChange(c1);
			c1.apply(doc);
			
			// Initially it should not be possible to redo.
			assertFalse(undoManager.canRedo());
			
			//Undo should be possible
			assertTrue(undoManager.canUndo());
			
			undoManager.undo();
			// Redo should now be possible
			assertTrue(undoManager.canRedo());
			assertFalse(undoManager.canUndo());
			
			undoManager.redo();
			Change r1 = undoManager.currentChange();
			assertEquals(c1, r1);
	    }

	    @Test
	    public void testUndoRedoMultipleTimes() {
	    	Document doc = new DocumentImpl();
			UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 3);
			undoManager.registerChange(c1);
			c1.apply(doc);

			undoManager.registerChange(c2);
			c2.apply(doc);

	        // 2 undo and 2 redo done repeatedly.
	        for (int i = 0; i < 5; i++) {
	            // 2 Undos
				Change u2 = undoManager.currentChange();// First undo should return last change
				assertEquals(c2, u2);
				undoManager.undo();

				Change u1 = undoManager.currentChange();
				assertEquals(c1, u1);
				undoManager.undo();

	            // 2 Redos
				undoManager.redo();
	            assertEquals(c1, undoManager.currentChange()); // First redo should return first change
	            undoManager.redo();
	            assertEquals(c2, undoManager.currentChange());
	        }
	    }

	    // If an operation is made after an undo, we can not redo the prior changes.
	    public void testAddAfterUndoRedo() {
	    	Document doc = new DocumentImpl();
			UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 3);
			undoManager.registerChange(c1);
			undoManager.registerChange(c2);
			undoManager.registerChange(c3);
			
			c1.apply(doc);
			c2.apply(doc);
			c3.apply(doc);
			
	        // 2 Undo
	        undoManager.undo();
	        undoManager.undo();
	        
	        // Now add another change
	        undoManager.registerChange(c4);
			
			c4.apply(doc);
	        // Now we should have last change C4 at the beginning and C1 (first change)
	        // in the end and C2, C3 discarded.
	        assertEquals(c4, undoManager.currentChange());
	        undoManager.undo();
	        assertEquals(c1, undoManager.currentChange());

	        // Now do 1 redo
	        undoManager.redo();
	        assertEquals(c4, undoManager.currentChange());
	}
}
