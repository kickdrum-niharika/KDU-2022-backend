package entities.transactions;

import entities.Coin;
import entities.transactions.Transaction;

public class UpdatePrice extends Transaction
{
    double newPrice;
    public UpdatePrice(Coin coin, double price)
    {
        newPrice = price;
    }

    @Override
    public String toString() {
        return "UpdatePrice{" +
                "transactionId='" + transactionId + '\'' +
                ", coin=" + coin +
                ", newPrice=" + newPrice +
                '}';
    }
}
