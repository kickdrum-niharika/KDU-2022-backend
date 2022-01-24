package IPL.model.readData;

import IPL.model.game.League;
import exception.TeamDoesnotExist;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader
{

    public CSVReader(League league)
    {
        String path = "/home/niharika/IdeaProjects/IPL/resources/IPL_2021_data.csv";
        BufferedReader bufferedReader = null;

        try
        {
            bufferedReader = new BufferedReader(new FileReader(path));
            String header = bufferedReader.readLine();

            String row;
            while((row = bufferedReader.readLine()) != null)
                league.createPlayer(row.split(","));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TeamDoesnotExist e) {
            e.printStackTrace();
        }
    }


}
