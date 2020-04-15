package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import command.NewDocument;
import model.Document;

public class NewDocumentTest {
	Document dummyDoc = new Document();
	
	NewDocument newDocument = new NewDocument(null, null, dummyDoc,1);
	
	@Test
	public void test() {
		if(dummyDoc.getContents().size() == 0) {
			System.out.println("SUCC");
		}
		else {
			fail("NewDocument Test Failed: Document not empty.");
		}
	}
	
}
