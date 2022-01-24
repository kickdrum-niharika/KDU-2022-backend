package IPL.model.participants;

import org.jetbrains.annotations.NotNull;

public class Bowler extends Player implements Comparable<Bowler>
{
    public Bowler(String playerName, int matchesPlayed, int runsScored, float playerAverage, float playerSR, int wicketsTaken)
    {
        super(playerName,matchesPlayed,runsScored,playerAverage,playerSR,wicketsTaken);
    }

    public int getWicketsTaken()
    {
        return wicketsTaken;
    }

    @Override
    public int compareTo(@NotNull Bowler b1) {
        return (this.getWicketsTaken()> b1.getWicketsTaken())?1:((this.getWicketsTaken()== b1.getWicketsTaken()?0:-1));
    }
}
