package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import encodingstrategies.*;
import text2speechapis.*;

public class Document {

	private ArrayList<Line> contents;
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	private String author;
	private String title;
	private LocalDate creationDate;
	private LocalDate savedDate;

	public Document() {
		this.contents = new ArrayList<Line>();
	}

	//setters
	public void setCreationDate(LocalDate date) {
		this.creationDate = date;
	}

	public void setSavedDate(LocalDate date) {
		this.savedDate = date;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContents(ArrayList<Line> contents) {
		this.contents = contents;
	}

	//getters
	public String getAuthor() {
		return author;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public LocalDate getSavedDate() {
		return savedDate;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Line> getContents() {
		return contents;
	}

	

	//Text2speech functions
	public void playContents() {
		TextToSpeechAPIFactory fact = new TextToSpeechAPIFactory();
		TextToSpeechAPI adapter = fact.createTTSAPI("real");
		//TextToSpeechAPI adapter = (TextToSpeechAPI) fact;
		
		//convert contents into a string
		StringBuilder contentStringBuilder = new StringBuilder();
		for (int k=0; k<contents.size(); k++) {
			for (String s : contents.get(k).getWords()) 
			{
				if(s.length() == 0){
					contentStringBuilder.append(" ");
				}
				else {
					contentStringBuilder.append(s);
				}
			}
			contentStringBuilder.append("\n");
		}
		adapter.play(contentStringBuilder.toString());
	}

	public void playReverseContents() {
		TextToSpeechAPIFactory fact = new TextToSpeechAPIFactory();
		TextToSpeechAPI adapter = fact.createTTSAPI("real");
		
		//convert contents into a string
		String contentString = new String();
		for (int k=0; k<contents.size(); k++) {
			for (String s : contents.get(k).getWords()) 
			{
				contentString += " " + s;
			}
			contentString += "\n";
		}
		
		//reverse the string
		String string = "";
	    String[] words = contentString.toString().split("\\n");
	    for (int j = 0; j < words.length; j++) {
		    String temp[] = words[j].toString().split(" ");
		    for (int k = 0; k < temp.length; k++) {
		    	string = temp[k] + " " + string;
		    }
	    }
	   
	   adapter.play(string);
	    
	}

	public void playLine(int num) {
		//check if the row num returned from LineToSpeech is within limits and then if the row is empty
		if(num <= contents.size()){
			if(!contents.get(num-1).getWords().isEmpty()) {
				//call Line with the correct line text
				Line lineVoice = new Line(contents.get(num-1).getWords());
				lineVoice.playLine();
			}
		}
	}
	
	public void playReverseLine(int num) {
		//check if the row num returned from LineToSpeech is within limits and then if the row is empty
		if(num >= contents.size()){
			return;
		}	
		if(contents.get(num-1).getWords().isEmpty()) {
			return;
		}
		
		if(num <= contents.size()) {
			//create string for reverse process 		    
		    String reverceLine = "";
		    for(int i=0; i<contents.get(num-1).getWords().size(); i++) { 
		    	reverceLine = contents.get(num-1).getWords().get(i) + " " + reverceLine; 
		    }
		    //create arraylist from string for Line constructor
			ArrayList<String> reverceLineArray = new ArrayList<String>(Arrays.asList(reverceLine.split(" ")));
			    
			//call Line with the correct line text
			Line lineVoice = new Line(reverceLineArray);
			lineVoice.playReverseLine();
		}
	}

	//Encoding functions
	public void playEncodedContents() {

	}

	public void playEncodedLine(int num) {

	}

	public void tuneEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
	}
}
