package utilities.loadData;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import entities.Trader;

public class TraderCreator
{
    public ArrayList<Trader> createTrader(String path)
    {

        Map<String, String> mapping = new HashMap<String, String>();
        mapping.put("Name", "name");
        mapping.put("Phone", "phone");
        mapping.put("Wallet Address", "walletId");

        HeaderColumnNameTranslateMappingStrategy<Trader> strategy =
                new HeaderColumnNameTranslateMappingStrategy<Trader>();
        strategy.setType(Trader.class);
        strategy.setColumnMapping(mapping);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(path));
        }
        catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();

        List<Trader> list = csvToBean.parse(strategy, csvReader);

        return new ArrayList<Trader>(list);
    }
}
