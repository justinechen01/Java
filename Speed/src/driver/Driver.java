package driver;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws InterruptedException, IOException {
		WordGenerator generate = new WordGenerator(args[0]);
		int width = Integer.valueOf(args[1]);
		int height = Integer.valueOf(args[2]);
		int fontsize = Integer.valueOf(args[3]);
		int wpm = Integer.valueOf(args[4]);
		DrawingPanel panel = new DrawingPanel(width, height);
		while (generate.hasNext()) {
			//DrawingPanel panel = new DrawingPanel(width, height);
			demonstratePanel(panel, generate.next(), height, width, fontsize);
			Thread.sleep(60000/wpm);
			panel.clear();
		}
		 Graphics g = panel.getGraphics();
		 String wordCount = String.valueOf(generate.getWordCount());
		 String sentenceCount = String.valueOf(generate.getSentenceCount());
		 g.drawString("Word Count: " + wordCount, 0, 50);
		 g.drawString("Sentence: " + sentenceCount, 0, 100);
		
	}
	//clearRect(int x, int y, int width, int height)
	public static void demonstratePanel(DrawingPanel panel, String word, int height, int width, int fontsize) {
		  Graphics g = panel.getGraphics();
		  //g.clearRect(50, 50, 400,300);
		  Font f = new Font("Courier", Font.BOLD, fontsize);
		  
		  g.setFont(f);
		  g.drawString(word, 100, 100);
		  
		  // g.setColor(Color.white);
		  
		 // g.fillRect(50, 50, width, height);
		 // g.clearRect(50, 50, width, height);		
		  //panel.clearWithoutRepaint();
		  //g.setXORMode(Color.blue);
		 // g.clearRect(100, 100, 400,300);
		}

}
