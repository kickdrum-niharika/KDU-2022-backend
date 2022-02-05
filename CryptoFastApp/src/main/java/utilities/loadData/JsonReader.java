package utilities.loadData;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.transactions.Transaction;


import java.io.File;
import java.io.IOException;

public class JsonReader
{
    public Transaction[] readJSON(String path) throws IOException {

        ObjectMapper jsonMapper = ObjectMapperCreator.getInstance();

        Transaction[] test  = jsonMapper.readValue(new File(path),Transaction[].class);
//        for (Transaction t:
//             test) {
//            System.out.println(t);
//        }
           return test;


    }

}
