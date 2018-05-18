package test;

import java.util.Scanner;
import javax.swing.JTextArea;

import gui.ThreadsGUI;
import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	private Singer guitarSolo;
	
	private void initializeSingingThreads(JTextArea ta) {
		String lyrics1 = "Because the night";
		String lyrics2 = "Belongs to lovers";
		String solo = "  x x        x      x    x    xxxxx    x x x       x x x\r\n" + 
				" x            x      x    x       x      x       x     x      x\r\n" + 
				"x             x      x    x       x      x        x    x      x\r\n" + 
				"x             x      x    x       x      x        x    x x x\r\n" + 
				"x     x x    x      x    x       x      xxxxxxx    x   x\r\n" + 
				" x       x    x      x    x       x      x        x    x     x\r\n" + 
				"  x x x        x x x     x       x      x        x    x      x";
		boolean stopIt = false;
		Synchronizer synch = new Synchronizer(true, false, false, ta);

		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		Performance soloPerformance = new Performance(solo, 3000);

		pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
		guitarSolo = new Singer("Guitar solo", Voice.BACKGROUND, soloPerformance, stopIt, synch);
	}

	public synchronized void testSingInThreads(JTextArea ta) {
		initializeSingingThreads(ta);

		pattiSmith.start();
		bruceSpringsteen.start();
		guitarSolo.start();
	}
	
	public synchronized void stopSingingThreads(){

		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
		guitarSolo.setStopIt(true);
	}
}
