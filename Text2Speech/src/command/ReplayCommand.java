package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ReplayCommand implements ActionListener{
	private static ArrayList<ActionListener> replayCommands = new ArrayList<ActionListener>();
	private int saveIndex;
	
	public ReplayCommand(int saveIndex){
		this.saveIndex = saveIndex;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(saveIndex == 1){
			saveRecording();
		}
		else if(saveIndex == 2){
			replay(replayCommands);	
		}			
		else if(saveIndex == 3){
			startRecording();	
		}			
	}
	//read log file and remplay commands
	public void replay(ArrayList<ActionListener> replayCommands){
		for(int i=0; i<replayCommands.size(); i++) {
			replayCommands.get(i).actionPerformed(null);;
		}
	}
	
	//set start index in CommandFactory true 
	public void startRecording(){
		replayCommands.clear();
		CommandFactory.setStartReplayBool(true);
	}
	
	//read log file for header and close it with end header
	public void saveRecording(){
		CommandFactory.setStartReplayBool(false);
			
		System.out.println(Arrays.toString(replayCommands.toArray()));		
	}
	
	//add command to arraylist
	public static void addCommandToArraylist(ActionListener command) {
		replayCommands.add(command);
		
	}
}
