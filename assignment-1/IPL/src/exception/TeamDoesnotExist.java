package exception;

public class TeamDoesnotExist extends Exception
{
    public TeamDoesnotExist()
    {
        super("Entered Team is not playing IPL this season");
    }

}
