package com.android.razertask.view;


import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.razertask.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }

    BottomSheetBehavior bottomSheetBehavior;
    View bottomSheet;
    ImageView imageLeftBud, imageViewRightBud, batterleft, batteryRight;
    LinearLayout settingLayout;
    Button btnRemap, btnTutorial;
    TextView textViewleft, textViewRight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initViews(v);
        launchDashboard();
        return v;
    }

    private void initViews(View view) {
        imageLeftBud = (ImageView) view.findViewById(R.id.earbud_left);
        imageViewRightBud = (ImageView) view.findViewById(R.id.earbud_right);
        settingLayout = (LinearLayout) view.findViewById(R.id.setting_layout);
        btnRemap = (Button) view.findViewById(R.id.btnRemap);
        btnTutorial = (Button) view.findViewById(R.id.btnTutorial);
        batterleft = (ImageView) view.findViewById(R.id.imageView4);
        batteryRight = (ImageView) view.findViewById(R.id.imageView5);
        textViewleft = (TextView) view.findViewById(R.id.textView2);
        textViewRight = (TextView) view.findViewById(R.id.textView3);
        bottomSheet = view.findViewById(R.id.bottom_sheet);

        settingLayout.setVisibility(View.GONE);
        btnRemap.setVisibility(View.GONE);
        btnTutorial.setVisibility(View.GONE);
        batterleft.setVisibility(View.GONE);
        batteryRight.setVisibility(View.GONE);
        textViewleft.setVisibility(View.GONE);
        textViewRight.setVisibility(View.GONE);
    }

    private void launchDashboard() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageLeftBud, View.Y, 500f);
        animator.setDuration(800);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();


        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageViewRightBud, View.Y, 500f);
        animator1.setDuration(800);
        animator1.setInterpolator(new AccelerateDecelerateInterpolator());
        animator1.start();

        launchViews();
    }

    private void launchViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                settingLayout.setVisibility(View.VISIBLE);
                btnRemap.setVisibility(View.VISIBLE);
                btnTutorial.setVisibility(View.VISIBLE);
                batterleft.setVisibility(View.VISIBLE);
                batteryRight.setVisibility(View.VISIBLE);
                textViewleft.setVisibility(View.VISIBLE);
                textViewRight.setVisibility(View.VISIBLE);
                settingLayout.setVisibility(View.VISIBLE);
            }
        }, 500);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
    }

}
