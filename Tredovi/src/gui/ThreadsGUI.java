package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadsGUI tg = new ThreadsGUI();
					tg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public ThreadsGUI() {
		setResizable(false);
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
					t.funkcija(getTextArea());
					//t.testSingInThreads(getTextArea());
				}
			});
		}
		return btnPlay;
	}
	private JButton getBtnPause() {
		if (btnPause == null) {
			btnPause = new JButton("Pause");
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
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
