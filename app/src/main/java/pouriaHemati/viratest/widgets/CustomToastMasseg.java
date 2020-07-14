package pouriaHemati.viratest.widgets;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import pouriaHemati.viratest.R;


public class CustomToastMasseg {

    private static CustomToastMasseg  customToastMasseg= null;

    public static CustomToastMasseg getCustomToastMasseg(){
        if (customToastMasseg == null)
            customToastMasseg = new CustomToastMasseg();
        return customToastMasseg;
    }

    public void showToastMessage(Context context, String message){

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout_custom_toast,
                (ViewGroup) ((Activity) context).findViewById(R.id.card_view));
        // set a message
        TextView text = (TextView) layout.findViewById(R.id.custom_toast_message);
        text.setText(message);

        // Toast...
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.BOTTOM, 0, 0);

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}
