package entities.transactions;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import entities.Coin;
import utilities.loadData.TransactionDeserializer;


import java.util.Random;

@JsonDeserialize(using = TransactionDeserializer.class)
public class Transaction
{
    String transactionId;
    Coin coin;
    Transaction()
    {
        transactionId = getBlockHash();
    }
    public String getBlockHash()
    {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();
/**
 * Introducing delay mimicking complex
 * calculation being performed.
 */
        for(double i=0;i<199999999; i++)
        {
            i = i;
        }
        while (transactionHash.length() < 128)
        {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }
        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", coin=" + coin +
                '}';
    }
}
