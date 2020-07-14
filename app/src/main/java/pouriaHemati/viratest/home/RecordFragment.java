package pouriaHemati.viratest.home;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import pouriaHemati.viratest.R;
import pouriaHemati.viratest.base.BaseActivity;
import pouriaHemati.viratest.camera.PortrateActivity;


public class RecordFragment extends Fragment {
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 88888;
    View view;
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_record, container, false);
        ButterKnife.bind(this, view);
        view.findViewById(R.id.portrate).setOnClickListener(v -> {
            PortrateActivity.startActivity(getActivity());
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        checkPermission();
    }
    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        // request camera permission if it has not been grunted.

        if (ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {

            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_PERMISSION_REQUEST_CODE);
            return false;
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case CAMERA_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(BaseActivity.getContext(), "camera permission has been grunted.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BaseActivity.getContext(), "[WARN] camera permission is not grunted.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
