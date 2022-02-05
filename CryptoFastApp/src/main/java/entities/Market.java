package entities;

import entities.transactions.Transaction;
import utilities.loadData.CoinCreator;
import utilities.loadData.JsonReader;
import utilities.loadData.TraderCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Market
{
    public static ArrayList<Coin> coins;
    public static ArrayList<Trader> traders;
    private TreeMap<String, Transaction> transactionHistory;
    public Transaction[] unprocessedTransactions;

    public void addCoins()
    {
        coins = new CoinCreator().createCoin("/home/niharika/Downloads/coins.csv");
    }

    public void addTraders()
    {
        traders = new TraderCreator().createTrader("/home/niharika/Downloads/traders.csv");
    }

    public void readTransactions() throws IOException {
        JsonReader  reader = new JsonReader();
        unprocessedTransactions = reader.readJSON("/home/niharika/Downloads/test_transaction.json");
//        for (Transaction t:
//             unprocessedTransactions)
//        {
//            System.out.println(t);
//        }
    }

    public void addTransaction(Transaction transaction)
    {
        String transactionId=getBlockHash();
        transactionHistory.put(transactionId,transaction);
    }

    private String getBlockHash() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();
        /**
         * Introducing delay mimicking complex
         * calculation being performed.
         */
        for(double i=0;i<199999999; i++){
            i = i;
        }
        while (transactionHash.length() < 128) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }
        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }

    public Trader findTrader(String walletId)
    {
        //stream
        for (Trader t:traders)
        {
            if(walletId.equals(t.walletId))
            {
                return t;
            }

        }
        return null;
    }
//    public Coin findCoin(String symbol)
//    {
//
//    }


}
