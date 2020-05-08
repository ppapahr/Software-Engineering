package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import command.CommandFactory;
import encodingstrategies.EncodingStrategy;
import model.Document;
import model.Line;
import text2speechapis.TextToSpeechAPI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
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
	    
		//initialize toolbars
		JToolBar toolBar = new JToolBar();
		JToolBar soundToolBar = new JToolBar();

		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		frame.getContentPane().add(soundToolBar, BorderLayout.SOUTH);

		//initialize menubars
		JMenuBar menuBar = new JMenuBar();

		toolBar.add(menuBar);

		//add sliders
		JSlider soundSlider = new JSlider(0,100,50);
		soundSlider.setMajorTickSpacing(25);
		soundSlider.setPaintTicks(true);
		
		// Set the labels to be painted on the slider
		soundSlider.setPaintLabels(true);
		         
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		position.put(0, new JLabel("0"));
		position.put(50, new JLabel("Sound Level"));
		position.put(100, new JLabel("100"));
		         
		// Set the label to be drawn
		soundSlider.setLabelTable(position);
		
		JSlider rateSlider = new JSlider(0,1000,150);
		rateSlider.setMajorTickSpacing(100);
		rateSlider.setPaintTicks(true);
		rateSlider.setPaintLabels(true);
		         
		Hashtable<Integer, JLabel> position2 = new Hashtable<Integer, JLabel>();
		position2.put(0, new JLabel("0"));
		position2.put(500, new JLabel("Rate level"));;
		position2.put(1000, new JLabel("1000"));
		         
		rateSlider.setLabelTable(position2);
		
		//pitch spinner
		JLabel spinnerText = new JLabel("<html>Pitch <br/>Level </html>", SwingConstants.CENTER);
		spinnerText.setSize(10, 10);
		SpinnerModel model = new SpinnerNumberModel(100, 0, 500, 1);     
		JSpinner spinner = new JSpinner(model);

		//sound save button
		JButton saveSound = new JButton(new ImageIcon("img/soundsave.png"));
		saveSound.setToolTipText("Save sound settings.");


		//add soundToolbar components
		soundToolBar.add(soundSlider);
		soundToolBar.add(rateSlider);
		soundToolBar.add(spinnerText);
		soundToolBar.add(spinner);
		soundToolBar.add(saveSound);

		
		//Add menus
		JMenu mnNewMenu = new JMenu("File");
		JMenu mnPlayMenu = new JMenu("Play");
		JMenu mnEncodeMenu = new JMenu("Encode");


		menuBar.add(mnNewMenu);
		menuBar.add(mnPlayMenu);
		menuBar.add(mnEncodeMenu);


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
		
		
		//audio related sounds
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Play document");
		mnPlayMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(commandFactory.createCommand("Play document"));
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Play line");
		mnPlayMenu.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(commandFactory.createCommand("Play line"));
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Play reverse document");
		mnPlayMenu.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(commandFactory.createCommand("Play reverse document"));
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Play reverse line");
		mnPlayMenu.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(commandFactory.createCommand("Play reverse line"));
		
		//encoding related commands
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Rot13");
		mnEncodeMenu.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.addActionListener(commandFactory.createCommand("Rot13"));
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("AtBash");
		mnEncodeMenu.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.addActionListener(commandFactory.createCommand("AtBash"));
		
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
