package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import command.CommandFactory;
import encodingstrategies.EncodingStrategy;
import model.Document;
import model.Line;
import text2speechapis.TextToSpeechAPI;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Text2SpeechEditorView {

	//Swing components
	private JFrame frame;
	JTextArea textArea = new JTextArea();

	//command listeners
	private static CommandFactory commandFactory;
	
	//Constructor
	public Text2SpeechEditorView() {
		initialize();
	}
	
	//Document
	private Document curDocument;
	
	//Basic window function
	private void initialize() {
		frame = new JFrame("Text2Speech Editor");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initialize Document
		curDocument = new Document();
		
	    //initialize command factory
	    commandFactory = new CommandFactory(textArea, frame, curDocument);
	    
		//initialize toolbar
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		//initialize menubar
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		//Add menu
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		//Add menu items and actionListeners linking to commands
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(commandFactory.createCommand("New"));
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Open...");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(commandFactory.createCommand("Open..."));

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(commandFactory.createCommand("Save"));
		
		JMenuItem mntmNewMenuItem_0 = new JMenuItem("Edit");
		mnNewMenu.add(mntmNewMenuItem_0);
		mntmNewMenuItem_0.addActionListener(commandFactory.createCommand("Edit"));
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Play document");
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(commandFactory.createCommand("Play document"));
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Play line");
		mnNewMenu.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(commandFactory.createCommand("Play line"));
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Play reverse document");
		mnNewMenu.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(commandFactory.createCommand("Play reverse document"));
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Play reverse line");
		mnNewMenu.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(commandFactory.createCommand("Play reverse line"));
		
		//Add scroll pane to the frame
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		//add text area to scrollpane
		scrollPane.setViewportView(textArea);
		
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text2SpeechEditorView window = new Text2SpeechEditorView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
