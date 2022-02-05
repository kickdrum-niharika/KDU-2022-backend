package entities.transactions;

import entities.Coin;
import entities.Trader;

public class Buy extends Transaction
{
    Trader trader;
    int quantity;
    public Buy(Trader t, Coin c, int quantity)
    {
        trader = t;
        coin = c;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "trader=" + trader +
                ", quantity=" + quantity +
                ", transactionId='" + transactionId + '\'' +
                ", coin=" + coin +
                '}';
    }
}
