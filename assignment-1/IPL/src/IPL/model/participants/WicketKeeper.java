package IPL.model.participants;

import org.jetbrains.annotations.NotNull;

public class WicketKeeper extends Player implements Comparable<WicketKeeper>
{
    public WicketKeeper(String playerName, int matchesPlayed, int runsScored, float playerAverage, float playerSR, int wicketsTaken)
    {
        super(playerName,matchesPlayed,runsScored,playerAverage,playerSR,wicketsTaken);
    }


    @Override
    public int compareTo(@NotNull WicketKeeper b1) {
        return (this.getWicketsTaken()> b1.getWicketsTaken())?1:((this.getWicketsTaken()== b1.getWicketsTaken()?0:-1));

    }
}
