package ua.itea;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {

	private JPanel panel1 = null;

	public Main() {
		super("Frame");
		setSize(200, 400);
		panel1 = panelBuild();
		add(panel1);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JPanel panelBuild() {
		JPanel panel = new JPanel();
		
		URL url1 = getClass().getClassLoader().getResource("1.txt");
		String text = "";
		try {
			Scanner myReader = new Scanner(url1.openStream());
			while (myReader.hasNextLine()) {
				text += myReader.nextLine();
			}
			myReader.close();
		} catch (IOException e ) {
			System.out.println("An error occurred.");
		}	
		panel.add(new JLabel(text));
		URL url2 = getClass().getClassLoader().getResource("images/pudge.png");
		panel.add(new JLabel(new ImageIcon(url2)));
		panel.setBackground(Color.gray);
		panel.setLayout(new GridLayout(4, 1));
		return panel;
	}

	public static void main(String[] args) {
		new Main();
	}

}