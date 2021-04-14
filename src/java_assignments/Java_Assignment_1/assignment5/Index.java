//package java_assignments.assignment5;

import java.util.*;

public class Index {
    Map<String, ArrayList<Integer>> occurences;
    public Index(Readable text) {
        Scanner sc = new Scanner(text);
        occurences = new HashMap<String, ArrayList<Integer>>();
        int lineNo = 1;
        try {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split("\\W+");
                String previous = words[0];
                int index = 0;
                int length=words.length;
                for(String word : words)
                {   
                    String current_word=new String(word);
                    word = word.toLowerCase();
                    ArrayList<Integer> list = occurences.get(word);
                    if (list == null) {
                        list = new ArrayList<>();
                        list.add(lineNo);
                    } else {
                        list.add(lineNo);
                    }
                    occurences.put(word, list);
                    for(int i=1;i<3;i++)
                    {
                        if((index+i)<length)
                        {
                            current_word = current_word +" " + words[index+i];
                            current_word.toLowerCase();
                            ArrayList<Integer> list1 = occurences.get(current_word);
                            if (list1 == null) {
                                list1 = new ArrayList<>();
                                list1.add(lineNo);
                            } 
                            else {
                                list1.add(lineNo);
                            }
                            occurences.put(current_word, list1);
                        }
                        else
                        {
                            break;
                        }
                    }
                    index++;
                }
                lineNo++;
            }
        } finally {
            sc.close();
        }
    }

    public String toString() {
        return occurences.toString();
    }
}
