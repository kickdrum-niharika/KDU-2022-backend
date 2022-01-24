package IPL.model.game;

import IPL.model.participants.AllRounder;
import IPL.model.participants.Batsman;
import IPL.model.participants.Bowler;
import IPL.model.participants.WicketKeeper;
import com.opencsv.CSVWriter;
import exception.TeamDoesnotExist;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class League
{
    private int leagueYear;
    private List <Team> mainTeamsList;
    private TreeMap<Integer,Match> matchFixture;
    private List<Batsman>mainBatsmenList;
    private List<Bowler>mainBowlersList;
    private List<WicketKeeper>mainWicketKeepersList;
    private List<AllRounder>mainAllRoundersList;


    public League(int year)
    {
       leagueYear = year;
       mainTeamsList = new ArrayList<>();
       mainBatsmenList = new ArrayList<>();
       mainBowlersList = new ArrayList<>();
       mainWicketKeepersList = new ArrayList<>();
       mainAllRoundersList = new ArrayList<>();
       matchFixture = new TreeMap<>();

    }


    public void setLeagueYear(int leagueYear) {
        this.leagueYear = leagueYear;
    }

    public void addTeam(Team team)
    {
        mainTeamsList.add(team);
    }

    public Match createMatch(Team homeTeam,Team awayTeam)
    {
        Match newMatch = new Match(homeTeam,awayTeam,homeTeam.getHomeGround());
        return newMatch;
    }

    public int getLeagueYear() {
        return leagueYear;
    }

    public List<AllRounder> getAllRounders() {
        return mainAllRoundersList;
    }

    public List<Batsman> getBatsmen() {
        return mainBatsmenList;
    }

    public List<Bowler> getBowlers() {
        return mainBowlersList;
    }

    public List<Team> getTeams() {
        return mainTeamsList;
    }

    public Team findTeam(String teamName) throws TeamDoesnotExist {

        for(Team t : mainTeamsList)
        {
            if(teamName.equals(t.getTeamName()))
            {
                return t;
            }
        }
        throw new TeamDoesnotExist();
        //throw teamname not found exception
    }

    public void createMatchFixture() throws IOException {
        List <Match> matchList = new ArrayList<>();
        for (Team homeTeam:mainTeamsList)
        {
            for(Team awayTeam : mainTeamsList)
            {
                if(homeTeam!=awayTeam)
                {
                    matchList.add(createMatch(homeTeam,awayTeam));

                }

            }
        }
        Collections.shuffle(matchList);
        int i = 1;
        for (Match m: matchList)
        {
            matchFixture.put(i++,m);
        }
        writeToCsv(matchFixture);
    }

    private void writeToCsv(TreeMap<Integer, Match> matchFixture) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("/home/niharika/IdeaProjects/IPL/resources/IPL_matchFixture.csv")) ;
        writer.writeNext(new String[]{"Match Number", "Team Home", "Team Away", "Venue"});
        Match m;
        for (Map.Entry<Integer, Match>
                matchInfo : matchFixture.entrySet())
        {
            m = matchInfo.getValue();
            writer.writeNext(new String[]{matchInfo.getKey().toString(),m.getTeamHome().getTeamName(),m.getTeamAway().getTeamName().toString()});
        }
        writer.close();
    }

    public void searchPlayer(String name)
    {
        name = name.toUpperCase();
        String finalName = name;
        mainBowlersList.stream().filter(bowler -> bowler.getPlayerName().contains(finalName)).forEach(System.out::println);
        mainBatsmenList.stream().filter(batsman -> batsman.getPlayerName().contains(finalName)).forEach(System.out::println);
        mainWicketKeepersList.stream().filter(wicketKeeper -> wicketKeeper.getPlayerName().contains(finalName)).forEach(System.out::println);
        mainAllRoundersList.stream().filter(allRounder -> allRounder.getPlayerName().contains(finalName)).forEach(System.out::println);
    }

    public void topNPlayers(int n)
    {
        topNBowlers(n);
        topNBatsmen(n);
        topNAllRounders(n);
    }
    public void topNBowlers(int n)
    {
        Collections.sort(mainBowlersList,Collections.reverseOrder());
        int i = 0;
        for (Bowler b: mainBowlersList)
        {
            if(i++<n)
            {
                System.out.println(b.getPlayerName()+" : "+b.getWicketsTaken());
            }

        }
    }
    public void topNBatsmen(int n)
    {
        Collections.sort(mainBatsmenList,Collections.reverseOrder());
        int i = 0;
        for (Batsman b: mainBatsmenList)
        {
            if(i++<n)
            {
                System.out.println(b.getPlayerName()+" : "+b.getWicketsTaken());
            }

        }
    }
    public void topNAllRounders(int n)
    {
        Collections.sort(mainAllRoundersList,Collections.reverseOrder());
        int i = 0;
        for (AllRounder b : mainAllRoundersList)
        {
            if(i++<n)
            {
                System.out.println(b.getPlayerName()+" : "+b.getWicketsTaken());
            }


        }
    }

    public void createPlayer(String @NotNull [] playerDetails) throws TeamDoesnotExist {
        Team t;
        try
        {
            t = findTeam(playerDetails[1]);
        }
        catch (Exception e)
        {
            createTeam(playerDetails[1]);
            t = findTeam(playerDetails[1]);
        }


        switch(playerDetails[2]) {
            case "BOWLER" :
                Bowler bowler = createBowler(playerDetails);
                addBowler(bowler);
                t.addBowler(bowler);
            case "BATSMAN" :
                Batsman batsman = createBatsman(playerDetails);
                addBatsman(batsman);
                t.addBatsman(batsman);
            case "WICKET KEEPER" :
                WicketKeeper wicketKeeper = createWicketKeeper(playerDetails);
                addWicketKeeper(wicketKeeper);
                t.addWicketKeeper(wicketKeeper);
            case "ALL ROUNDER" :
                AllRounder allRounder = createAllRounder(playerDetails);
                addAllRounder(allRounder);
                t.addAllRounder(allRounder);

        }
    }

    public void createTeam(String teamName)
    {
        for (Team t: mainTeamsList)
        {
            if(t.getTeamName().equals(teamName))
            {
                return;
            }

        }
        Team team = new Team(teamName);
        mainTeamsList.add(team);
    }
    


    private void addBowler(Bowler bowler)
    {
        mainBowlersList.add(bowler);
    }

    private void addBatsman(Batsman batsman)
    {
        mainBatsmenList.add(batsman);
    }

    private void addWicketKeeper(WicketKeeper wicketKeeper)
    {
        mainWicketKeepersList.add(wicketKeeper);
    }

    private void addAllRounder(AllRounder allRounder)
    {
        mainAllRoundersList.add(allRounder);
    }

    @Contract("_ -> new")
    private static @NotNull AllRounder createAllRounder(String @NotNull [] stringOfPlayerProfile)
    {
        return new AllRounder(stringOfPlayerProfile[0].toUpperCase(),Integer.parseInt(stringOfPlayerProfile[3]),Integer.parseInt(stringOfPlayerProfile[4]),Float.parseFloat(stringOfPlayerProfile[5]),Float.parseFloat(stringOfPlayerProfile[6]),Integer.parseInt(stringOfPlayerProfile[7]));
    }

    @Contract("_ -> new")
    private static @NotNull WicketKeeper createWicketKeeper(String @NotNull [] stringOfPlayerProfile)
    {
        return new WicketKeeper(stringOfPlayerProfile[0].toUpperCase(),Integer.parseInt(stringOfPlayerProfile[3]),Integer.parseInt(stringOfPlayerProfile[4]),Float.parseFloat(stringOfPlayerProfile[5]),Float.parseFloat(stringOfPlayerProfile[6]),Integer.parseInt(stringOfPlayerProfile[7]));
    }

    @Contract("_ -> new")
    private static @NotNull Batsman createBatsman(String @NotNull [] stringOfPlayerProfile)
    {
        return new Batsman(stringOfPlayerProfile[0].toUpperCase(),Integer.parseInt(stringOfPlayerProfile[3]),Integer.parseInt(stringOfPlayerProfile[4]),Float.parseFloat(stringOfPlayerProfile[5]),Float.parseFloat(stringOfPlayerProfile[6]),Integer.parseInt(stringOfPlayerProfile[7]));
    }

    @Contract("_ -> new")
    private static @NotNull
    Bowler createBowler(String @NotNull [] stringOfPlayerProfile)
    {
        return new Bowler(stringOfPlayerProfile[0].toUpperCase(),Integer.parseInt(stringOfPlayerProfile[3]),Integer.parseInt(stringOfPlayerProfile[4]),Float.parseFloat(stringOfPlayerProfile[5]),Float.parseFloat(stringOfPlayerProfile[6]),Integer.parseInt(stringOfPlayerProfile[7]));

    }

    public void showTeams()
    {

        for (Team t:
             mainTeamsList)
        {
            System.out.println("-------------------------------------------------------------");
            System.out.println("\nTeam Name : "+t.getTeamName());
            t.showPlayers();

        }

    }

    public void showMatchFixture()
    {
        for(Map.Entry<Integer, Match>
                matchInfo : matchFixture.entrySet())
        {
            Match m = matchInfo.getValue();
            System.out.print("Match :"+matchInfo.getKey()+"\n");
            m.showMatch();
        }
    }
    public void setHomeGrounds(String [] homeGrounds)
    {
        int i = 0;
        for (Team t:mainTeamsList)
        {
            t.setHomeGround(homeGrounds[i++]);

        }
    }

}
