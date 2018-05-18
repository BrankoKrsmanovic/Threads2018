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

	private void initializeSingingThreads(JTextArea ta, int e) {
		String lyrics1 = "Because the night";
		String lyrics2 = "Belongs to lovers";
		String solo = "  x x        x      x    x    xxxxx    x x x       x x x\r\n"
				+ " x            x      x    x       x      x       x     x      x\r\n"
				+ "x             x      x    x       x      x        x    x      x\r\n"
				+ "x             x      x    x       x      x        x    x x x\r\n"
				+ "x     x x    x      x    x       x      xxxxxxx    x   x\r\n"
				+ " x       x    x      x    x       x      x        x    x     x\r\n"
				+ "  x x x        x x x     x       x      x        x    x      x";
		boolean stopIt = false;
		Synchronizer synch = new Synchronizer(true, false, false, ta, e);

		if (e == 2)
			synch = new Synchronizer(false, true, false, ta, e);
		else if (e == 3)
			synch = new Synchronizer(false, false, true, ta, e);

		// Synchronizer synch = new Synchronizer(true, false, false, ta);

		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		Performance soloPerformance = new Performance(solo, 3000);

		pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
		guitarSolo = new Singer("Guitar solo", Voice.BACKGROUND, soloPerformance, stopIt, synch);
	}

	public synchronized void testSingInThreads(JTextArea ta) {
		initializeSingingThreads(ta, 4);

		pattiSmith.start();
		bruceSpringsteen.start();
		guitarSolo.start();
	}

	public synchronized void startSpecificThread(int e, JTextArea ta) {

		if (e == 1) {
			initializeSingingThreads(ta, 1);
			pattiSmith.start();
		} else if (e == 2) {
			initializeSingingThreads(ta, 2);
			bruceSpringsteen.start();
		} else {
			initializeSingingThreads(ta, 3);
			guitarSolo.start();
		}
	}

	public synchronized void stopFirstThread() {
		try {
			pattiSmith.setStopIt(true);
		} catch (Exception e) {
		}
	}

	public synchronized void stopSecondThread() {
		try {
			bruceSpringsteen.setStopIt(true);
		} catch (Exception e) {
		}
	}

	public synchronized void stopThirdThread() {
		try {
			guitarSolo.setStopIt(true);
		} catch (Exception e) {
		}
	}

	public synchronized void stopSingingThreads() {
		try {
			pattiSmith.setStopIt(true);
			bruceSpringsteen.setStopIt(true);
			guitarSolo.setStopIt(true);
		} catch (Exception e) {
		}
	}
}
