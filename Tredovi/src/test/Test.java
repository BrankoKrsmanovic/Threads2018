package test;
import java.util.Scanner;
import javax.swing.JTextArea;
import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	private Singer guitarSolo;
	
	//public static ThreadsGUI tg;

	private void initializeSingingThreads(JTextArea ta) {
		String lyrics1 = "Because the night";
		String lyrics2 = "Belongs to lovers";
		String solo = "  xxx  x   x  x  xxxxx  xx    xxx\n"
					+ " x     x   x  x    x   x  x  x   x\n"
					+ "x      x   x  x    x   x  x  x   x\n"
					+ "x      x   x  x    x   xxxx  xxxx\n"
					+ "x  xx  x   x  x    x   x  x  x x\n"
					+ " x  x  x   x  x    x   x  x  x  x\n"
					+ "  xxx   xxx   x    x   x  x  x   x";

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

		IN.nextLine();
		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
		guitarSolo.setStopIt(true);
	}
	
	public void funkcija(JTextArea ta) {
		funkcija2(ta);
	}
	
	public void funkcija2(JTextArea ta) {
		Synchronizer synch = new Synchronizer(false, false, false, ta);
		synch.funkcija1223();
	}
}
