package de.fuberlin.winfo.project.visualization.web.start;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import de.fuberlin.winfo.project.visualization.web.VisualizationServer;

public class GuiStart {
	static VisualizationServer server = null;

	public static void main(String[] args) throws InterruptedException {
		final JFrame frame = new JFrame();
		frame.add(new JLabel(" Outout"), BorderLayout.NORTH);

		JTextArea ta = new JTextArea();
		TextAreaOutputStream taos = new TextAreaOutputStream(ta, 60);
		PrintStream ps = new PrintStream(taos);
		System.setOut(ps);
		System.setErr(ps);

		frame.add(new JScrollPane(ta));

		frame.pack();
		frame.setVisible(true);

		frame.setSize(new Dimension(500 + frame.getInsets().left + frame.getInsets().right + 500,
				frame.getInsets().top + frame.getInsets().bottom + 500));
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		try {
			server = new VisualizationServer(8080);
			server.setNWDirectory("target/networks");
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, "Are you sure to close this window?", "Really Closing?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					try {
						server.stop();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						System.exit(0);
					}
				}
			}
		});
	}
}