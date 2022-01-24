package IPL.model.participants;

import org.jetbrains.annotations.NotNull;

public class AllRounder extends Player implements Comparable<AllRounder>
{
    public AllRounder(String playerName, int matchesPlayed, int runsScored, float playerAverage, float playerSR, int wicketsTaken)
    {
        super(playerName,matchesPlayed,runsScored,playerAverage,playerSR,wicketsTaken);
    }


    @Override
    public int compareTo(@NotNull AllRounder b1) {
        return ((this.getRunsScored()> b1.getRunsScored())||(this.getWicketsTaken()> b1.getWicketsTaken()))?1:((this.getRunsScored()== b1.getRunsScored()?0:-1));

    }
}
