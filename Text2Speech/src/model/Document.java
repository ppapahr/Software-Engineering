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
		/*
		this.contents = contents;
		this.encodingStrategy = encodingStrategy;
		this.audioManager = audioManager;
		*/
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

	public void setContents(ArrayList<Line> contents) {
		this.contents = contents;
	}

	//Text2speech functions
	public void playContents() {

	}

	public void playReverseContents() {

	}

	public void playLine(int num) {

	}

	//Encoding functions

	public void playEncodedContents() {

	}



	public void playReverseLine(int num) {

	}

	public void playEncodedLine(int num) {

	}

	public void tuneEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
	}
}
