import java.lang.StringBuffer;
import edu.princeton.cs.algs4.SeparateChainingHashST;
public class WordFinder {
    private SeparateChainingHashST<String, Val> hashST;

    private class Val {
	int line, appear;

	    public Val(int l, int a) {
		line = l;
		appear = a;
	    }
	}
    
    public WordFinder (String[] words) {
	hashST = new SeparateChainingHashST<String, Val>();
	StringBuffer buffer;
	int line = 1;

	for (String s : words) {
	    for (int j = 0; j < s.length(); j++) {
		buffer = new StringBuffer();
		char letter = s.charAt(j);

		while (letter != ' ') {
		    buffer.append(letter);
		    j++;
		    letter = s.charAt(j);
		}
		if (buffer.length() > 0) {
		    if (!hashST.contains(buffer.toString())) {
			Val v = new Val(line, 1);
			hashST.put(buffer.toString(), v);
		    }
		    else {
			Val v = hashST.get(buffer.toString());
			if (v.line != line) {
			    v.appear += 1;
			    hashST.put(buffer.toString(), v);
			}
		    }  
		}
		
	    }
	    line++;
	}
    }
}
