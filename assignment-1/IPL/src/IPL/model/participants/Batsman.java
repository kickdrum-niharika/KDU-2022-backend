package IPL.model.participants;

import org.jetbrains.annotations.NotNull;

public class Batsman extends Player implements Comparable<Batsman>
{
    public Batsman(String playerName, int matchesPlayed, int runsScored, float playerAverage, float playerSR, int wicketsTaken)
    {
        super(playerName,matchesPlayed,runsScored,playerAverage,playerSR,wicketsTaken);
    }

    @Override
    public int compareTo(@NotNull Batsman b1) {
        return (this.getRunsScored()> b1.getRunsScored())?1:((this.getRunsScored()== b1.getRunsScored()?0:-1));

    }
}
