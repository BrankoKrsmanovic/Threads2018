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
import java.awt.Dimension;
import javax.swing.JTextField;

public class ThreadsGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnPlay;
	private JButton btnPause;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private Test t = new Test();
	private JButton btnClear;
	private JButton btnStopT;
	private JPanel panel_1;
	private JButton btnStartT;
	private JButton btnStartT_1;
	private JButton btnStartT_2;
	private JButton btnStopT_1;
	private JButton btnStopT_2;

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
		contentPane.add(getPanel_1(), BorderLayout.WEST);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnPlay());
			panel.add(getBtnPause());
			panel.add(getBtnClear());
		}
		return panel;
	}

	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("Play");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnPlay.setEnabled(false);
					btnStartT_1.setEnabled(false);
					btnStartT_2.setEnabled(false);
					btnStartT.setEnabled(false);
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
					btnStartT_1.setEnabled(true);
					btnStartT_2.setEnabled(true);
					btnStartT.setEnabled(true);
					btnStopT.setEnabled(true);
					btnStopT_1.setEnabled(true);
					btnStopT_2.setEnabled(true);
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

	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextArea().setText("");
				}
			});
		}
		return btnClear;
	}

	private JButton getBtnStopT() {
		if (btnStopT == null) {
			btnStopT = new JButton("Stop T1");
			btnStopT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main.stopFirstThread();
					btnPlay.setEnabled(true);
					btnStartT_1.setEnabled(true);
					btnStartT_2.setEnabled(true);
					btnStartT.setEnabled(true);
					btnStopT.setEnabled(true);
					btnStopT_1.setEnabled(true);
					btnStopT_2.setEnabled(true);
				}
			});
			btnStopT.setPreferredSize(new Dimension(110, 23));
		}
		return btnStopT;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(120, 120));
			panel_1.add(getBtnStartT());
			panel_1.add(getBtnStartT_1());
			panel_1.add(getBtnStartT_2());
			panel_1.add(getBtnStopT());
			panel_1.add(getBtnStopT_1());
			panel_1.add(getBtnStopT_2());
		}
		return panel_1;
	}

	private JButton getBtnStartT() {
		if (btnStartT == null) {
			btnStartT = new JButton("Start T1");
			btnStartT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnPlay.setEnabled(false);
					btnStartT.setEnabled(false);
					btnStartT_1.setEnabled(false);
					btnStartT_2.setEnabled(false);
					btnStopT_1.setEnabled(false);
					btnStopT_2.setEnabled(false);
					Main.startSpecificThread(1);
				}
			});
			btnStartT.setPreferredSize(new Dimension(110, 23));
		}
		return btnStartT;
	}

	private JButton getBtnStartT_1() {
		if (btnStartT_1 == null) {
			btnStartT_1 = new JButton("Start T2");
			btnStartT_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPlay.setEnabled(false);
					btnStartT.setEnabled(false);
					btnStartT_1.setEnabled(false);
					btnStartT_2.setEnabled(false);
					btnStopT.setEnabled(false);
					btnStopT_2.setEnabled(false);
					Main.startSpecificThread(2);
				}
			});
			btnStartT_1.setPreferredSize(new Dimension(110, 23));
		}
		return btnStartT_1;
	}

	private JButton getBtnStartT_2() {
		if (btnStartT_2 == null) {
			btnStartT_2 = new JButton("Start T3");
			btnStartT_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPlay.setEnabled(false);
					btnStartT.setEnabled(false);
					btnStartT_1.setEnabled(false);
					btnStartT_2.setEnabled(false);
					btnStopT_1.setEnabled(false);
					btnStopT.setEnabled(false);
					Main.startSpecificThread(3);
				}
			});
			btnStartT_2.setPreferredSize(new Dimension(110, 23));
		}
		return btnStartT_2;
	}

	private JButton getBtnStopT_1() {
		if (btnStopT_1 == null) {
			btnStopT_1 = new JButton("Stop T2");
			btnStopT_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main.stopSecondThread();
					btnPlay.setEnabled(true);
					btnStartT_1.setEnabled(true);
					btnStartT_2.setEnabled(true);
					btnStartT.setEnabled(true);
					btnStopT.setEnabled(true);
					btnStopT_1.setEnabled(true);
					btnStopT_2.setEnabled(true);
				}
			});
			btnStopT_1.setPreferredSize(new Dimension(110, 23));
		}
		return btnStopT_1;
	}

	private JButton getBtnStopT_2() {
		if (btnStopT_2 == null) {
			btnStopT_2 = new JButton("Stop T3");
			btnStopT_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main.stopThirdThread();
					btnPlay.setEnabled(true);
					btnStartT_1.setEnabled(true);
					btnStartT_2.setEnabled(true);
					btnStartT.setEnabled(true);
					btnStopT.setEnabled(true);
					btnStopT_1.setEnabled(true);
					btnStopT_2.setEnabled(true);
				}
			});
			btnStopT_2.setPreferredSize(new Dimension(110, 23));
		}
		return btnStopT_2;
	}
}
