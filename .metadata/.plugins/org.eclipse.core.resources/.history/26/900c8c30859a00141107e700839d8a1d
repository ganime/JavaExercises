package undo;

public class UndoManagerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentImpl doc = new DocumentImpl();

		UndoManagerFactory undoManagerFactory = new UndoManagerFactoryImpl();
		UndoManager undoManager = undoManagerFactory.createUndoManager(doc, 10);
		ChangeFactory changeFactory = new ChangeFactoryImpl();
		Change insertion1 = changeFactory.createInsertion(0, "Hello ", 0,
				"Hello".length());
		undoManager.registerChange(insertion1);
		insertion1.apply(doc);
		System.out.println("Document:" + doc.getContent());

		Change insertion2 = changeFactory.createInsertion(5, ",", 0,
				",".length());
		undoManager.registerChange(insertion2);
		insertion2.apply(doc);
		System.out.println("Document:" + doc.getContent());

		Change insertion3 = changeFactory.createInsertion(6, "world", 0,
				"world".length());
		undoManager.registerChange(insertion3);
		insertion3.apply(doc);
		System.out.println("Document:" + doc.getContent());

		undoManager.undo();
		System.out.println("Document:" + doc.getContent());

		undoManager.undo();
		System.out.println("Document:" + doc.getContent());

		undoManager.redo();
		System.out.println("Document:" + doc.getContent());

		Change insertion4 = changeFactory.createInsertion(6, "ganime", 0,
				"ganime".length());
		undoManager.registerChange(insertion4);
		insertion4.apply(doc);
		System.out.println("Document:" + doc.getContent());

		// undoManager.redo();
		// doc.print();

		undoManager.undo();
		System.out.println("Document:" + doc.getContent());

		undoManager.redo();
		System.out.println("Document:" + doc.getContent());

		// test delete
		Change deletion1 = changeFactory.createDeletion(0, "Hello", 0, 0);
		undoManager.registerChange(deletion1);
		deletion1.apply(doc);
		System.out.println("Document:" + doc.getContent());

		undoManager.undo();
		System.out.println("Document:" + doc.getContent());

		undoManager.redo();
		System.out.println("Document:" + doc.getContent());

		undoManager.undo();
		System.out.println("Document:" + doc.getContent());
	}
}
