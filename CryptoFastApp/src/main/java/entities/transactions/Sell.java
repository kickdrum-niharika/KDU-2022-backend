package entities.transactions;

import entities.Coin;
import entities.Trader;

public class Sell extends Transaction
{
    Trader trader;
    int quantity;
    public Sell(Trader t, Coin c, int quantity)
    {
        trader = t;
        coin = c;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "trader=" + trader +
                ", quantity=" + quantity +
                ", transactionId='" + transactionId + '\'' +
                ", coin=" + coin +
                '}';
    }
}

