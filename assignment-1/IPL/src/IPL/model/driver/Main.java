package IPL.model.driver;

import IPL.model.game.League;
import IPL.model.game.Team;
import IPL.model.readData.CSVReader;
import exception.EmptyPlayerName;
import exception.TeamDoesnotExist;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws TeamDoesnotExist, IOException {
        League league2022 = new League(2022);
        CSVReader csvReader = new CSVReader(league2022);
        System.out.println("IPL Data read successfully!");
        String[] homeGrounds = {"Ground A", "Ground B", "Ground C", "Ground D", "Ground E", "Ground F", "Ground G", "Ground H"};
        league2022.setHomeGrounds(homeGrounds);
        league2022.createMatchFixture();
        Scanner sc = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.println("######################################\nMain Menu");
            System.out.println("1.Bowlers with atleast 40 wickets in a team:\n" +
                    "2.Search a player\n" +
                    "3.Highest Wicket Taker of a Team\n" +
                    "4.Highest Run Scorer of a Team\n" +
                    "5.Top 3 Batsmen,Bowlers and All Rounders of the Season\n" +
                    "6.Next Gen Players of a Team");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Team Name:");
                    Team t = league2022.findTeam(sc.next());
                    if (t != null) {
                        t.bowlersAboveN(40);
                    } else {
                        System.out.println("Invalid Team Name!!");
                    }
                    break;
                case 2:
                    System.out.println("Enter player name:");
                    String name = sc.next();
                    try
                    {
                        if(name.isEmpty()||name=="\n")
                        {
                            throw new EmptyPlayerName();
                        }
                        league2022.searchPlayer(name);
                    } catch (EmptyPlayerName e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:

                    System.out.println("Enter team name:");
                    league2022.findTeam(sc.next()).highestWicketTaker();
                    break;
                case 4:
                    System.out.println("Enter team name:");
                    league2022.findTeam(sc.next()).highestRunScorer();
                    break;
                case 5:
                    league2022.topNPlayers(3);
                    break;
                case 6:
                    System.out.println("Enter team name:");
                    league2022.findTeam(sc.next()).findNextGenPlayers();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}