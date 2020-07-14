package pouriaHemati.viratest.sport.adapter;



import java.util.ArrayList;

import pouriaHemati.viratest.model.JGame;


public class ModelItemJGame {


    ArrayList<JGame> jGames;

    public ModelItemJGame(ArrayList<JGame> jGames) {
        this.jGames = jGames;

    }


    public void setJGame(ArrayList<JGame> jGames) {
        this.jGames = jGames;
    }

    public ArrayList<JGame>  getJGame() {
        return jGames;
    }
}


