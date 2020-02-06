package com.android.razertask.view;


import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.android.razertask.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }

    ImageView imageLeft, imageViewRight;

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
        imageLeft = (ImageView) view.findViewById(R.id.earbud_left);
        imageViewRight = (ImageView) view.findViewById(R.id.earbud_right);
    }

    private void launchDashboard()
    {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageLeft, View.Y, 500f);
        animator.setDuration(800);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();


        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageViewRight, View.Y, 500f);
        animator1.setDuration(800);
        animator1.setInterpolator(new AccelerateDecelerateInterpolator());
        animator1.start();
    }
}
