package pouriaHemati.viratest.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import pouriaHemati.viratest.R;


public class Home4 extends Fragment {

    View view;
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_home4, container, false);
        ButterKnife.bind(this, view);


        return view;
    }


}
