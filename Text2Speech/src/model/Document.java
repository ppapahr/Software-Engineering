package model;

import java.time.LocalDate;
import java.util.ArrayList;
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
		
		//reverse the string
		String string = "";
	    String[] words = contentStringBuilder.toString().split("\\n");
	    for (int j = 0; j < words.length; j++) {
		    String temp[] = words[j].toString().split(" ");
		    for (int k = 0; k < temp.length; k++) {
		    	string = temp[k] + " " + string;
		    }
	    }
	   adapter.play(string);
	    
	}

	public void playLine(int num) {
		//Line lineVoice = new Line(contents.get(num));
		System.out.println(contents.get(1).getWords());
		
	}
	
	public void playReverseLine(int num) {

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
