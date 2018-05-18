package music;

import javax.swing.JTextArea;

public class Synchronizer {

	private boolean firstVoiceFlag;
	private boolean secondVoiceFlag;
	private boolean soloFlag;
	private JTextArea ta;
	private int mode;

	public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean soloFlag, JTextArea ta, int mode) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
		this.secondVoiceFlag = secondVoiceFlag;
		this.soloFlag = soloFlag;
		this.ta = ta;
		this.mode = mode;
	}

	public synchronized void singFirstVoice(String lyrics, int delay) {
		while (!firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singSecondVoice(String lyrics, int delay) {
		while (!secondVoiceFlag || firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void guitarSolo(String lyrics, int delay) {
		while (!soloFlag || firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	private void sing(String lyrics, int delay) {
		// System.out.println(lyrics);
		ta.append(lyrics + "\n");

		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mode == 4) {
			if (firstVoiceFlag) {
				firstVoiceFlag = false;
				secondVoiceFlag = true;
				soloFlag = false;
			} else {
				if (secondVoiceFlag) {
					firstVoiceFlag = false;
					secondVoiceFlag = false;
					soloFlag = true;
				} else if (soloFlag) {
					firstVoiceFlag = true;
					secondVoiceFlag = false;
					soloFlag = false;
				}
			}
			notifyAll();
		} else {
			if (mode == 1) {
				firstVoiceFlag = true;
				secondVoiceFlag = false;
				soloFlag = false;
				notifyAll();
			} else if (mode == 2) {
				firstVoiceFlag = false;
				secondVoiceFlag = true;
				soloFlag = false;
				notifyAll();
			} else if (mode == 3) {
				firstVoiceFlag = false;
				secondVoiceFlag = false;
				soloFlag = true;
				notifyAll();
			}
		}

	}
}
