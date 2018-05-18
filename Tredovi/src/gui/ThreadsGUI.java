package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import test.Test;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadsGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnPlay;
	private JButton btnPause;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private Test t = new Test();

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ThreadsGUI() {
		setTitle("ThreadsGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnPlay());
			panel.add(getBtnPause());
		}
		return panel;
	}
	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("Play");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnPlay.setEnabled(false);
					Main.testSingingThreads();
				}
			});
		}
		return btnPlay;
	}
	private JButton getBtnPause() {
		if (btnPause == null) {
			btnPause = new JButton("Pause");
			btnPause.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Main.stopSingingThreads();
				btnPlay.setEnabled(true);
				}
			});
		}
		return btnPause;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
