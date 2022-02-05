package entities.transactions;

import entities.Coin;

public class AddVolume extends Transaction
{
    long increaseInSupply;

    public AddVolume(Coin coin, long increaseInSupply)
    {
        this.coin = coin;
        this.increaseInSupply = increaseInSupply;

    }

    @Override
    public String toString() {
        return "AddVolume{" +
                "increaseInSupply=" + increaseInSupply +
                ", transactionId='" + transactionId + '\'' +
                ", coin=" + coin +
                '}';
    }
}
