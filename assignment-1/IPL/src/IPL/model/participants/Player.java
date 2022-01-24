package IPL.model.participants;

public class Player
{
    String playerName;
    int matchesPlayed;
    int runsScored;
    float playerAverage;
    float playerSR;
    int wicketsTaken;
    Player(){}
    Player(String playerName,int matchesPlayed,int runsScored,float playerAverage,float playerSR, int wicketsTaken)
    {
        this.playerName = playerName;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
        this.playerAverage = playerAverage;
        this.playerSR = playerSR;
        this.wicketsTaken = wicketsTaken;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setPlayerAverage(float playerAverage) {
        this.playerAverage = playerAverage;
    }

    public void setPlayerSR(float playerSR) {
        this.playerSR = playerSR;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public float getPlayerAverage() {
        return playerAverage;
    }

    public float getPlayerSR() {
        return playerSR;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "\nPlayer Profile\n" +
                "playerName='" + playerName + '\n' +
                "matchesPlayed=" + matchesPlayed + '\n' +
                "runsScored=" + runsScored + '\n' +
                "playerAverage=" + playerAverage + '\n' +
                "playerSR=" + playerSR + '\n' +
                "wicketsTaken=" + wicketsTaken
                ;
    }

    
}
