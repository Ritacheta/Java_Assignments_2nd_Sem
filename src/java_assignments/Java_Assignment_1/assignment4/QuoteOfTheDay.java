import java.io.IOException;

public class QuoteOfTheDay {
    public static void main(String[] args) throws IOException {
        QuoteProvider qp = new QuoteProvider();
        System.out.println("\n"+qp.getQuote()+"\n");
    }
}