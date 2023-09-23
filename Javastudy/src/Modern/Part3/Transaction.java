package Modern.Part3;

import java.util.Currency;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    private final Currency currency = null;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" + this.trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }

    public Currency getCurrency() {
        return currency;
    }
}
