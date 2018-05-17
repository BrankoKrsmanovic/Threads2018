package music;

public class Performance {

	private String lyrics;
	public int delay;
	
	public Performance(String lyrics, int delay) {
		super();
		this.lyrics = lyrics;
		this.delay = delay;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

}
