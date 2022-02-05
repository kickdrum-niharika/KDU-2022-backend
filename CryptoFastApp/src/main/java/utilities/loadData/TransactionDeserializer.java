package utilities.loadData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import entities.Coin;
import entities.Market;
import entities.Trader;
import entities.transactions.*;
import org.jetbrains.annotations.NotNull;


import java.io.IOException;
import java.util.ArrayList;


public class TransactionDeserializer extends StdDeserializer<Transaction> {


    protected TransactionDeserializer() {
        super(Transaction.class);
    }

    @Override
    public Transaction deserialize(@NotNull JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String type = node.get("type").toString();
        //System.out.println(type);
        String wallet_id;
        String coin_symbol;
        int quantity;
        int tr_type;
        double price;
        long volume;
        Transaction t = null;
        if(type.equals("BUY"))
        {
            tr_type=1;
            System.out.println("type : Buy");
        }
        else if(type.equals("SELL"))
        {
            tr_type=2;
        }
        else if(type.equals("ADD_VOLUME"))
        {
            tr_type = 3;
        }
        else
        {
            tr_type=4;
        }

        switch(tr_type)
        {
            case 1:
                System.out.println("Matched inside case");
                wallet_id = node.get("data").get("wallet_address").toString();
                        coin_symbol = node.get("data").get("coin").toString();
                        quantity = (Integer) ((IntNode) node.get("data").get("quantity")).asInt();
                        System.out.println(wallet_id);
                        t = new Buy(findTrader(Market.traders,wallet_id),findCoin(Market.coins,coin_symbol),quantity);
                        break;
//            case 2: wallet_id = node.get("data").get("wallet_address").toString();
//                         coin_symbol = node.get("data").get("coin").toString();
//                         quantity = (Integer) ((IntNode) node.get("data").get("quantity")).asInt();
//                         t = new Sell(findTrader(Market.traders,wallet_id),findCoin(Market.coins,coin_symbol),quantity);
//                         break;
//            case 3: volume = (Long) ((LongNode)node.get("data").get("volume")).asLong();
//                        coin_symbol = node.get("data").get("coin").toString();
//                        t = new AddVolume(findCoin(Market.coins,coin_symbol),volume);
//                        break;
//            case 4: coin_symbol = node.get("data").get("coin").toString();
//                        price = (Double) ((DoubleNode)node.get("data").get("volume")).asDouble();
//                        t = new UpdatePrice(findCoin(Market.coins,coin_symbol),price);
//                        break;
            default:System.out.println("i am in switch");
        }

        //System.out.println(t);
        return t;
    }

    private Coin findCoin(ArrayList<Coin> coins, String coin_symbol)
    {
        for(Coin c : coins)
        {
            if(c.symbol.equals(coin_symbol))
            {
                return c;
            }
        }
        return null;
    }

    private Trader findTrader(ArrayList<Trader> traders, String wallet_id)
    {
        for (Trader t: traders)
        {
            if(t.walletId.equals(wallet_id))
            {
                return t;
            }

        }
        return null;
    }

}
