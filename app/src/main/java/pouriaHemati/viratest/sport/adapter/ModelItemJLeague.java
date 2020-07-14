package pouriaHemati.viratest.sport.adapter;



import java.util.ArrayList;

import pouriaHemati.viratest.model.JGame;
import pouriaHemati.viratest.model.JLeague;


public class ModelItemJLeague {


    ArrayList<JLeague> jLeagues;

    public ModelItemJLeague(ArrayList<JLeague> jLeagues) {
        this.jLeagues = jLeagues;

    }


    public void setJGame(ArrayList<JLeague> jLeagues) {
        this.jLeagues = jLeagues;
    }

    public ArrayList<JLeague>  getJLeagues() {
        return jLeagues;
    }
}


