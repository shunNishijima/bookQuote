package nl.utwente.di.bookQuote;

import java.util.HashMap;

public class Quoter {
    private HashMap<String,Double> bookPrices;

    public Quoter(HashMap<String, Double> bookPrices) {
        this.bookPrices = bookPrices;
    }

    public double getBookPrice(String isbn){
        return bookPrices.getOrDefault(isbn, 0.0);
    }

}
