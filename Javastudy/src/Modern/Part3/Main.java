package Modern.Part3;

import java.util.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Main {
    static List<Transaction> transactions;
    public static void main(String[] args) {
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .collect(toList());

        


        

    }


}
