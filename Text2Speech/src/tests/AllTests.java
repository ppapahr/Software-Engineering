package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EditDocumentTest.class, NewDocumentTest.class, OpenDocumentTest.class, SaveDocumentTest.class,
		SpeechEncodingTest.class, TuneAudioTest.class })
public class AllTests {

}
