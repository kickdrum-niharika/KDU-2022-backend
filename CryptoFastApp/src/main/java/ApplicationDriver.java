import entities.Coin;
import entities.Market;
import entities.Trader;
import entities.transactions.Transaction;
import utilities.loadData.CoinCreator;
import utilities.loadData.TraderCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDriver
{
    public static void main(String[] args) throws IOException {

        Market today = new Market();
        today.addCoins();
        today.addTraders();
        today.readTransactions();
//        for (Transaction t: today.unprocessedTransactions)
//        {
//            System.out.println(t);
//
//        }

    }
}
