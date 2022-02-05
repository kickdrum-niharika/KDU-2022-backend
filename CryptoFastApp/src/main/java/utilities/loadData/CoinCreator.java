package utilities.loadData;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import entities.Coin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinCreator
{
    public ArrayList<Coin> createCoin(String path)
    {

        Map<String, String> mapping = new HashMap<String, String>();
        mapping.put("Name", "name");
        mapping.put("Symbol", "symbol");
        mapping.put("Price", "price");
        mapping.put("Circulating Supply", "circulatingSupply");

        HeaderColumnNameTranslateMappingStrategy<Coin> strategy =
                new HeaderColumnNameTranslateMappingStrategy<Coin>();
        strategy.setType(Coin.class);
        strategy.setColumnMapping(mapping);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(path));
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();

        List<Coin> list = csvToBean.parse(strategy, csvReader);

        return new ArrayList<Coin>(list);
    }
}
