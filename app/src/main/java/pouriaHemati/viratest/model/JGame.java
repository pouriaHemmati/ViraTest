package pouriaHemati.viratest.model;

import android.graphics.drawable.Drawable;

public class JGame {


    private Drawable team1;
    private Drawable team2;
    private String nameTeam1;
    private String nameTeam2;
    private int goalTeam1;
    private int goalTeam2;
    private String timeGame;
    private boolean live;
    private boolean gameCancel;
    private String startGame;


    public void setTeam1(Drawable team1) {
        this.team1 = team1;
    }

    public Drawable getTeam1() {
        return team1;
    }

    public Drawable getTeam2() {
        return team2;
    }

    public void setTeam2(Drawable team2) {
        this.team2 = team2;
    }

    public String getNameTeam1() {
        return nameTeam1;
    }

    public void setNameTeam1(String nameTeam1) {
        this.nameTeam1 = nameTeam1;
    }

    public String getNameTeam2() {
        return nameTeam2;
    }

    public void setNameTeam2(String nameTeam2) {
        this.nameTeam2 = nameTeam2;
    }

    public int getGoalTeam1() {
        return goalTeam1;
    }

    public void setGoalTeam1(int goalTeam1) {
        this.goalTeam1 = goalTeam1;
    }

    public int getGoalTeam2() {
        return goalTeam2;
    }

    public void setGoalTeam2(int goalTeam2) {
        this.goalTeam2 = goalTeam2;
    }

    public String getTimeGame() {
        return timeGame;
    }

    public void setTimeGame(String timeGame) {
        this.timeGame = timeGame;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isGameCancel() {
        return gameCancel;
    }

    public void setGameCancel(boolean gameCancel) {
        this.gameCancel = gameCancel;
    }

    public void setStartGame(String startGame) {
        this.startGame = startGame;
    }

    public String getStartGame() {
        return startGame;
    }
}