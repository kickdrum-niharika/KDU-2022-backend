package exception;

public class EmptyTeamName extends Exception
{
    EmptyTeamName()
    {
        super("Team Name cannot be empty");
    }
}
