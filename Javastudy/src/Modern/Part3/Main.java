package Modern.Part3;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Main {
    static List<Transaction> transactions;
    public static void main(String[] args) {
        // 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순 정렬
        List<Transaction> tr2011 =
                transactions.stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());

        // 거래자가 근무하는 모든 도시를 중복 없이 나열
        List<String> cities =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());

        // 캠브릿지에서 근무하는 모든 거래자 이름순
        List<Trader> traders =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());

        // 모든 거래자의 이름을 알파벳순 정렬 반환
        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("",(n1,n2) -> n1+n2);

        Map<Currency, List<Transaction>> transactionByCurrencies =
                    new HashMap<>();

//        for(Transaction transaction : transactions){
//                Currency currency = transaction.getCurrency();
//                List<Transaction> transactionsForCurrency =
//                        transactionByCurrencies.get(currency);
//                if (transactionsForCurrency == null){
//                    transactionByCurrencies = new ArrayList<>();
//                    transactionByCurrencies.put(currency, transactionsForCurrency);
//                }
//                transactionsForCurrency.add(transaction);
//            }

        

    }


}
