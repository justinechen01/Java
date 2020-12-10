package driver;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {
	private Scanner text;
	private int words;
	private int sentences;
	
	
	public WordGenerator (String filename) throws IOException {
		text = new Scanner(new File(filename));
		words = 0;
		sentences = 0;
	}
	
	public boolean hasNext() {
		return this.text.hasNext();
	}
	
	public String next() {
		this.words ++;
		String result = this.text.next();
		if (result.contains(".")) {
			this.sentences ++;
		} else if (result.contains("!")) {
			this.sentences ++;
		} else if (result.contains("?")) {
			this.sentences ++;
		}
		return result;
	}
	
	public int getWordCount() {
		return this.words;
	}
	
	public int getSentenceCount() {
		return this.sentences;
	}
	
	
}
