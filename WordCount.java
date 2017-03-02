
package mycounter;

import java.io.*;
import java.util.*;

public class WordCount {
    String inFile, outFile;
    public static String testString = "Lorem Ipsum, Lorem Ipsum, Lorem Ipsum";
    
    public Hashtable words = new Hashtable();
    
    public Hashtable getWords() {
       return words;
    }

    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }
    
    public void countWords(){
        Reader reader;
        int count=0;
        try {
            if (inFile ==null){
                reader = new StringReader(testString);
            }else {reader = new FileReader(inFile);}
            BufferedReader br=new BufferedReader(reader);
            
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                StringTokenizer st = new StringTokenizer(line, " \n,.:;" );
                while (st.hasMoreTokens()){
                    String token = st.nextToken();
                    if (words.containsKey(token)){
//                        Object val = words.get(token);
//                        int n=(int) val;
                        int n = (int) words.get(token);
                        n++;
                        words.put(token,n);                        
                    } else {
                        words.put(token,1);
                        count++;
                    }
                }
            }
            br.close();
            
        } 
        catch(IOException ex) {
            
        }
    }
}
