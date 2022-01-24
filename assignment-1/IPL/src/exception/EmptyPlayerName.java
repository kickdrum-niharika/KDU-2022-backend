package exception;

public class EmptyPlayerName extends Exception
{
    public EmptyPlayerName()
    {
        super("Player Name cannot be empty!!");

    }
}
