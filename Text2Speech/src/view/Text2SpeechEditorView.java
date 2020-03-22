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
	private static JScrollPane scrollableTextPane = new JScrollPane(textArea);
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
	    frame.setJMenuBar(menuBar);
	    frame.add(scrollableTextPane);
	}
	
	//Creates the File Menu and its items
	private void createMenu(){		
	    menuBar = new JMenuBar();
	    JMenu menuFile = new JMenu("File");
	    	    
	    //initialize command factory
	    commandFactory = new CommandFactory(textArea, frame);
	    
	    //menu items
        JMenuItem menuFileNew = new JMenuItem("New"); 
        JMenuItem menuFileOpen = new JMenuItem("Open...");
        JMenuItem menuFileSave = new JMenuItem("Save"); 

        //Add action listeners for menu items
        menuFileNew.addActionListener(commandFactory.createCommand("New"));
        menuFileOpen.addActionListener(commandFactory.createCommand("Open..."));
        menuFileSave.addActionListener(commandFactory.createCommand("Save"));

        
        //add items to menu "File"
	    menuFile.add(menuFileNew);
	    menuFile.add(menuFileOpen);
	    menuFile.add(menuFileSave);
	    //add "File" menu to the bar.
	    menuBar.add(menuFile);
	
	}
	
	private static void createText(){
		//add textArea to frame
		textArea.setEditable(true);
		textArea.setVisible(true);
		textArea.setBounds(0,25,windowWidth,windowHeight);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
	}
	
	private void buildApp(){
		createText();
		createMenu();
		createWindow();
	}

	public static void main(String[] args){
	    Text2SpeechEditorView mainEditor = new Text2SpeechEditorView();
	}
	
}