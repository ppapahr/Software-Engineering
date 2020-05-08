package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import encodingstrategies.EncodingStrategy;
import encodingstrategies.StrategiesFactory;
import model.Document;
import model.Line;

public class TuneEncoding implements ActionListener {
	
	private Document curDocument;
	private int choice;
	
	public TuneEncoding(Document curDocument, int choice) {
		this.curDocument = curDocument;
		this.choice = choice;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//check if document exists
		if(curDocument == null) {
			System.out.println("No document found");
			return;
		}
		//create encoding strategy factory
		EncodingStrategy encodingStrategy;
		StrategiesFactory factory = new StrategiesFactory();
		//check which encoding has been chosen
		if(choice == 1) {
			System.out.println("You chose AtBash");
			encodingStrategy = factory.createStrategy("atbash");
			curDocument.tuneEncodingStrategy(encodingStrategy);
			for(int i=0; i<curDocument.getContents().size(); i++) {
				curDocument.getContents().get(i).tuneEncodingStrategy(encodingStrategy);
			}
		}
		else if(choice == 2) {
			System.out.println("You chose Rot13");
			encodingStrategy = factory.createStrategy("rot13");
			curDocument.tuneEncodingStrategy(encodingStrategy);
			for(int i=0; i<curDocument.getContents().size(); i++) {
				curDocument.getContents().get(i).tuneEncodingStrategy(encodingStrategy);
			}
		}
	}
	
}
