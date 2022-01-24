package IPL.model.game;

import IPL.model.participants.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Team {
    private String teamName;
    private String homeGround;
    List<Batsman> batsmen;
    List<Bowler> bowlers;
    List<WicketKeeper> wicketKeepers;
    List<AllRounder> allRounders;

    Team(String teamName) {
        this.teamName = teamName;
        batsmen = new ArrayList<>();
        bowlers = new ArrayList<>();
        wicketKeepers = new ArrayList<>();
        allRounders = new ArrayList<>();
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setHomeGround(String homeGround) {
        this.homeGround = homeGround;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getHomeGround() {
        return homeGround;
    }


    public void addBatsman(Batsman batsman)
    {
        batsmen.add(batsman);
    }

    public void addBowler(Bowler bowler)
    {
        bowlers.add(bowler);
    }

    public void addAllRounder(AllRounder allRounder)
    {
        allRounders.add(allRounder);

    }

    void addWicketKeeper(WicketKeeper wicketKeeper)
    {
        wicketKeepers.add(wicketKeeper);

    }

    public void bowlersAboveN(int minimumWickets)
    {
        bowlers.stream().filter(bowler -> bowler.getWicketsTaken()>minimumWickets).forEach(System.out::println);

    }

    public void highestWicketTaker()
    {
        int maxWicketsTaken = Integer.MIN_VALUE;

        Player highestWicketTaker = null;
        WicketKeeper w = wicketKeepers.stream().max(Comparator.comparing(WicketKeeper ::getWicketsTaken )).get();
        AllRounder a = allRounders.stream().max(Comparator.comparing(AllRounder ::getWicketsTaken )).get();
        Bowler b = bowlers.stream().max(Comparator.comparing(Bowler ::getWicketsTaken )).get();
        //highestWicketTaker =
        System.out.println("Highest Wicket Taker : ");
        System.out.println(highestWicketTaker);
    }
    public void highestRunScorer()
    {
        int maxRunsScored = Integer.MIN_VALUE;

        Player highestRunScorer = null;
        for(Batsman b : batsmen)
        {
            if(b.getRunsScored()>maxRunsScored)
            {
                highestRunScorer = b;
                maxRunsScored = b.getRunsScored();
            }

        }
        for(AllRounder a : allRounders)
        {

            if(a.getRunsScored()>maxRunsScored)
            {
                highestRunScorer = a;
                maxRunsScored = a.getRunsScored();
            }

        }
        System.out.println("Highest Run Scorer : ");
        System.out.println(highestRunScorer);
        System.out.println(highestRunScorer.getPlayerName()+"\nRuns Scored: "+maxRunsScored);
    }


    public void showPlayers()
    {

        for (Batsman b:
             batsmen)
        {
            System.out.println(b);

        }
        for (Bowler b:
             bowlers) {
            System.out.println(b);
        }
        for (WicketKeeper w:
             wicketKeepers)
        {
            System.out.println(w);
        }
        for(AllRounder a : allRounders)
        {
            System.out.println(a);
        }
    }

    public void findNextGenAllRounder()
    {
        for (AllRounder p: allRounders)
        {
            if(p.getMatchesPlayed()<11 && (p.getRunsScored()>101||p.getWicketsTaken()>6))
            {
                System.out.println(p);
            }

        }
    }
    public void findNextGenBatsman()
    {
        for (Batsman p:batsmen)
        {
            if(p.getMatchesPlayed()<11 && (p.getRunsScored()>101||p.getWicketsTaken()>6))
            {
                System.out.println(p);
            }
        }
    }

    public void findNextGenBowler()
    {
        for (Bowler p: bowlers)
        {
            if(p.getMatchesPlayed()<11 && (p.getWicketsTaken()>6))
            {
                System.out.println(p);
            }
        }
    }

    public void findNextGenWicketKeeper()
    {
        for(WicketKeeper p : wicketKeepers)
        {
            if(p.getMatchesPlayed()<11 && (p.getWicketsTaken()>6))
            {
                System.out.println(p);
            }

        }
    }
    public void findNextGenPlayers()
    {
        findNextGenAllRounder();
        findNextGenBatsman();
        findNextGenBowler();
        findNextGenWicketKeeper();

    }
}

