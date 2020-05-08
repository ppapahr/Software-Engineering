package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.JSpinner;

import model.Document;

public class TuneAudio implements ActionListener{
	
	Document curDocument;
	JSlider volumeSlider;
	JSlider rateSlider;
	JSpinner pitchSpinner;
	
	public TuneAudio(Document curDocument, JSlider volumeSlider, JSlider rateSlider, JSpinner pitchSpinner) {
		this.curDocument = curDocument;
		this.volumeSlider = volumeSlider;
		this.rateSlider = rateSlider;
		this.pitchSpinner = pitchSpinner;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		curDocument.tuneAudioSettings(volumeSlider.getValue(), rateSlider.getValue(),(int)pitchSpinner.getValue());
	}
}
