/*
 TO DO LIST:
 SCROLL AREA IN TEXT AREA
 FINISH ALL OPERATIONS ( SAVE EXIT ETC. )
 */

package view;

import java.awt.Dimension;

import javax.swing.*; 
import command.CommandFactory;

//Class implements swings ActionListener
public class Text2SpeechEditorView{
	
	//window size
	private static int windowWidth = 500;
	private static int windowHeight = 500;
	
	//window components: i.e: frame,menus,text
	private static JFrame frame;
	private static JMenuBar menuBar;
	private static JTextArea textArea = new JTextArea();
		
	//command listeners
	private static CommandFactory commandFactory;
	
	//Editor constructor
	public Text2SpeechEditorView(){
		buildApp();
	}
	
	//Sets window dimensions and creates the JFrame
	private void createWindow(){
	    frame = new JFrame("Text2Speech Editor");
	    frame.setSize(windowWidth,windowHeight);
	    frame.setVisible(true);
	}
	
	//Creates the File Menu and its items
	private void createMenu(){		
	    JMenuBar menuBar = new JMenuBar();
	    JMenu menuFile = new JMenu("File");
	    	    
	    //initialize command factory
	    commandFactory = new CommandFactory(textArea);
	    
	    //menu items
        JMenuItem menuFileNew = new JMenuItem("New"); 
        JMenuItem menuFileOpen = new JMenuItem("Open");
        JMenuItem menuFileSave = new JMenuItem("Save"); 

        //Add action listeners for menu items
        menuFileNew.addActionListener(commandFactory.createCommand("New"));
        menuFileOpen.addActionListener(null);
        menuFileSave.addActionListener(null);

        
        //add items to menu "File"
	    menuFile.add(menuFileNew);
	    menuFile.add(menuFileOpen);
	    menuFile.add(menuFileSave);
	    //add "File" menu to the bar.
	    menuBar.add(menuFile);
	
	    frame.setJMenuBar(menuBar);
	}
	
	private static void createText(){
		//add textArea to frame
		frame.add(textArea);
		textArea.setBounds(0,25,windowWidth,windowHeight);
	}
	
	private void buildApp(){
		createWindow();
		createMenu();
		createText();
	}

	public static void main(String[] args){
	    Text2SpeechEditorView mainEditor = new Text2SpeechEditorView();
	}
	
}