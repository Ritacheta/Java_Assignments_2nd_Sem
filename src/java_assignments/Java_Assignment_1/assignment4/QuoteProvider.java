import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class QuoteProvider {
    private ArrayList<String> AM_QUOTES = new ArrayList<String>();
    private ArrayList<String> PM_QUOTES = new ArrayList<String>();
    // Special Quotes
    private HashMap<String, String> SP_QUOTES = new HashMap<String, String>();

    QuoteProvider() { // initializing with some quotes
        AM_QUOTES.add("Be yourself; everyone else is already taken.― Oscar Wilde");
        AM_QUOTES.add("A room without books is like a body without a soul. ― Marcus Tullius Cicero");
        AM_QUOTES.add("Be the change that you wish to see in the world. ― Mahatma Gandhi");
        AM_QUOTES.add("If you tell the truth, you don't have to remember anything. ― Mark Twain");
        AM_QUOTES.add(
                "If you want to know what a man's like, take a good look at how he treats his inferiors, not his equals.― J.K. Rowling");
        AM_QUOTES.add("To live is the rarest thing in the world. Most people exist, that is all.― Oscar Wilde");

        PM_QUOTES.add("Without music, life would be a mistake. ― Friedrich Nietzsche");
        PM_QUOTES.add("Always forgive your enemies, nothing annoys them so much. ― Oscar Wilde");
        PM_QUOTES.add("Life isn't about getting and having, it's about giving and being. – Kevin Kruse");
        PM_QUOTES.add("Whatever the mind of man can conceive and believe, it can achieve. – Napoleon Hill");
        PM_QUOTES.add("Strive not to be a success, but rather to be of value. – Albert Einstein");
        // special dates in form of dd/mm/yyyy
        SP_QUOTES.put("12/01", "The future of a nation depends upon the youth of the country. - Swami Vivekananda");
        SP_QUOTES.put("23/01",
                "One individual may die for an idea, but that idea will, after his death, incarnate itself in a thousand lives. - Netaji Subash Chandra Bose");
        SP_QUOTES.put("26/01", "An eye for eye only ends up making the whole world blind - Mahatma Gandhi.");
        SP_QUOTES.put("28/02",
                "The essence of science is independent thinking, hard work, and not equipment. - C. V. Raman.");
        SP_QUOTES.put("08/03",
                "Feminism isn’t about making women strong. Women are already strong. It’s about changing the way the world perceives that strength. - G. D. Anderson");
    }

    private String historyPath = "history.txt"; 

    public String getQuote() throws IOException {
        String spQuote = getQuoteifSpecialDay(); // Checks if special day
        if (spQuote != null)
            return spQuote;

        ArrayList<String> QUOTES;
        boolean pm = isPM(); // checks if AM or PM
        if (!pm) {
            QUOTES = AM_QUOTES;
        } else {
            QUOTES = PM_QUOTES;
        }
        int[] lastUsed = new int[QUOTES.size()]; 

        ArrayList<String> history = getHistory(); // to get the previous history of the current User
        ArrayList<Integer> probableQuotes = new ArrayList<Integer>(); 

        if (history != null) { // if history is present, then get probably quotes
            for (int i = 0; i < history.size(); i++) {
                String info = history.get(i);
                if (((info.split(" "))[0].equals("PM") && !pm) || (info.split(" ")[0].equals("AM") && pm)) 
                    continue;

                lastUsed[Integer.parseInt(info.split(" ")[1])] += 1; // for required history info, lastUsed is updated
            }
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < lastUsed.length; i++) {
            if (min > lastUsed[i]) {
                min = lastUsed[i];
            }
        }

        for (int i = 0; i < lastUsed.length; i++) { 
                if (min == lastUsed[i]) {
                probableQuotes.add(i);
            }
        }

        Random rand = new Random();
        int quoteIndex = probableQuotes.get(rand.nextInt(probableQuotes.size())); 
        writeToHistory(pm, quoteIndex); 
        return QUOTES.get(quoteIndex); 
    }

    private ArrayList<String> getHistory() { // read the history of quotes
        ArrayList<String> history = new ArrayList<String>();
        try {
            File f = new File(historyPath);
            Scanner scanFile = new Scanner(f);
            while (scanFile.hasNext()) {
                history.add(scanFile.nextLine());
            }
            scanFile.close();
        } catch (FileNotFoundException e) {
            history = null;
            System.gc();
        }
        return history;
    }

    private void writeToHistory(boolean pm, int quoteIndex) { 
        String write = String.format("%s %d", pm ? "PM" : "AM", quoteIndex);
        try {
            FileWriter writerFile = new FileWriter(historyPath, true);
            PrintWriter writer = new PrintWriter(writerFile);
            writer.println(write);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isPM() { // check if PM
        String currentTimeStamp = new SimpleDateFormat("h:mm a").format(new Date());
        return currentTimeStamp.substring(currentTimeStamp.length() - 2).equals("PM");
    }

    private String getQuoteifSpecialDay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
        LocalDateTime now = LocalDateTime.now();
        String ddmm = dtf.format(now);

        if (SP_QUOTES.keySet().contains(ddmm)) {
            System.out.println("Today is a Special Day!!");
            return SP_QUOTES.get(ddmm);
        } else
            return null;
    }

}
