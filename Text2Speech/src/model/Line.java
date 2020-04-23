package model;

import java.util.ArrayList;
import encodingstrategies.*;
import text2speechapis.*;

public class Line {
	private ArrayList<String> words;
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	
	public Line(ArrayList<String> words, EncodingStrategy encodingStrategy, TextToSpeechAPI audioManager) {
		this.words = words;
		this.encodingStrategy = encodingStrategy;
		this.audioManager = audioManager;
	}
	
	public Line(ArrayList<String> words) {
		this.words = words;
	}
	
	//getters
	
	public ArrayList<String> getWords() {
		return words;
	}
	
	// Text2Speech & Encoding functions
	
	public void playLine() {
		TextToSpeechAPIFactory fact = new TextToSpeechAPIFactory();
		TextToSpeechAPI adapter = fact.createTTSAPI("real");
		
		//create string from arraylist
		String voice = "";
		for (int j = 0; j < words.size(); j++) {
			if(words.get(j).length() == 0){
				voice = voice + " ";
			}
			else {
				voice = voice + words.get(j);
			}
		}
		
		//play text
		adapter.play(voice);
	}
	
	public void playReverseLine() {
		TextToSpeechAPIFactory fact = new TextToSpeechAPIFactory();
		TextToSpeechAPI adapter = fact.createTTSAPI("real");
		
		//create string from arraylist
		String voice = "";
		for (int j = 0; j < words.size(); j++) {
			if(words.get(j).length() == 0){
				voice = voice + " ";
			}
			else {
				voice = voice + words.get(j);
			}
		}
		
		//play text
		adapter.play(voice);
	}
	
	
	public void playEncodedLine() {
		
	}
	
	public void tuneEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
	}
}
