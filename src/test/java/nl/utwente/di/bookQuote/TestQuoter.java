package nl.utwente.di.bookQuote;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test ;

import java.util.HashMap;

/***Tests the Quoter*/
public class TestQuoter {

    @Test
    public void testBook1 ( ) throws Exception {
        HashMap<String,Double> bookPrices = new HashMap<>();
        bookPrices.put("1",10.0);
        bookPrices.put("2",45.0);
        bookPrices.put("3",20.0);
        bookPrices.put("4",35.0);
        bookPrices.put("5",50.0);
        Quoter quoter = new Quoter (bookPrices) ;
        double price = quoter.getBookPrice ("1") ;
        Assertions.assertEquals (10.0 ,price, 0.0 , "Price of book 1") ;
    }
}
