package entities;

import entities.transactions.Transaction;

import java.util.List;
import java.util.TreeMap;

public class Trader
{
    public String name;
    public String walletId;
    public String phone;
    public TreeMap<Coin,Integer> coinsOwned;
    public Float netWorth;
    public Float totalProfit;
    public List<Transaction> transactions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TreeMap<Coin, Integer> getCoinsOwned() {
        return coinsOwned;
    }

    private void calculateNetWorth()
    {

    }

    private void calculateProfit()
    {

    }

    public Float getNetWorth() {
        return netWorth;
    }

    public Float getTotalProfit() {
        return totalProfit;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void getProfile()
    {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Trader Profile:\n" +
                "Name='" + name + '\n' +
                "WalletId='" + walletId + '\n' +
                "Phone='" + phone + '\n' +
                "Net Worth=" + netWorth + '\n'+
                "Total Profit=" + totalProfit +'\n'
                ;
    }
}
