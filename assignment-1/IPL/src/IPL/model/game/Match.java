package IPL.model.game;

public class Match
{
    Team teamHome;
    Team teamAway;
    String venue;

    Match(Team home,Team away, String v)
    {
        teamHome = home;
        teamAway = away;
        venue = v;
    }

    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }

    public Team getTeamHome() {
        return teamHome;
    }

    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
    }

    public Team getTeamAway() {
        return teamAway;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void showMatch()
    {

        System.out.println(this.getTeamHome().getTeamName()+" V/S "+this.getTeamAway().getTeamName());
        System.out.println("Venue: "+this.getVenue());

    }


}
