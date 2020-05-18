package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import encodingstrategies.EncodingStrategy;
import encodingstrategies.StrategiesFactory;
import model.Document;

public class TuneEncoding implements ActionListener {
	
	private Document curDocument;
	private int choice;
	
	public TuneEncoding(Document curDocument, int choice) {
		this.curDocument = curDocument;
		this.choice = choice;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("tune encoding");
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
			encodingStrategy = factory.createStrategy("atbash");
			curDocument.tuneEncodingStrategy(encodingStrategy);
			//tune encoding for all the lines in doc
			for(int i=0; i<curDocument.getContents().size(); i++) {
				curDocument.getContents().get(i).tuneEncodingStrategy(encodingStrategy);
			}
			
			//check if we are recording commands
			if(CommandFactory.getStartReplayBool() == true) {
				addCommandToArray(choice);
			}
		}
		else if(choice == 2) {
			encodingStrategy = factory.createStrategy("rot13");
			curDocument.tuneEncodingStrategy(encodingStrategy);
			//tune encoding for all the lines in doc
			for(int i=0; i<curDocument.getContents().size(); i++) {
				curDocument.getContents().get(i).tuneEncodingStrategy(encodingStrategy);
			}
			
			//check if we are recording commands
			if(CommandFactory.getStartReplayBool() == true) {
				addCommandToArray(choice);
			}
		}
	}
	
	//add command to command array in ReplayCommand
	public void addCommandToArray(int choice) {
		TuneEncoding replayTuneEncoding = new TuneEncoding(curDocument, choice);
		//TuneEncoding replayTuneEncoding = this;
		ReplayCommand.addCommandToArraylist(replayTuneEncoding);
	}
}
