import java.lang.StringBuffer;
import edu.princeton.cs.algs4.SeparateChainingHashST;
public class WordFinder {
    private SeparateChainingHashST hashST;
    
    public WordFinder (String[] words) {
	hashST = new SeparateChainingHashST();
	StringBuffer buffer;

	for (int i = 0; i < words.length(); i++)
	    for (int j = 0; j < words[i].length(); j++) {
		buffer = new StringBuffer();
		char letter = words[i][j];

		while (letter != ' ') {
		    buffer.append(letter);
		    j++;
		    letter = words[i][j];
		}
		if (buffer.length() > 0) {
		    if (!hashST.contains(buffer.toString()))
		        hashST.put(buffer.toString(), 1);
		    else
			hashST.put(buffer.toString(), get(buffer.toString()) + 1);
			    
		}
		
	    }
		
    }
}
