package main;

import java.awt.EventQueue;

import gui.ThreadsGUI;
import test.Test;

public class Main {

	public static Test test;
	public static ThreadsGUI tg;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test = new Test();
					Main.tg = new ThreadsGUI();
					Main.tg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void testSingingThreads() {
		test.testSingInThreads(tg.getTextArea());
	}

	public static void stopSingingThreads() {
		test.stopSingingThreads();
	}
}
