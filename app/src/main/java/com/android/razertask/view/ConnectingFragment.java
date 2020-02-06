package com.android.razertask.view;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.razertask.R;
import com.android.razertask.viewmodel.ViewModelProvider;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConnectingFragment extends Fragment {


    public ConnectingFragment() {
        // Required empty public constructor
    }


    ImageView imageView, imageView1;
    TextView textView;
    MaterialProgressBar progressBar;
    Button button, button_cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_connecting, container, false);
        initViews(v);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_cancel.setEnabled(true);
                button_cancel.setText(getResources().getString(R.string.text_cancel));
                button.setEnabled(false);
                startProgress();
            }
        });
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setEnabled(true);
                button.setText(getResources().getString(R.string.text_search));
                button_cancel.setEnabled(false);
            }
        });
        ViewModelProvider viewModelProvider = ViewModelProviders.of(getActivity()).get(ViewModelProvider.class);

        return v;
    }


    private void startProgress() {


        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, View.Y, 500f);
        animator.setDuration(300);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();


        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView1, View.Y, 500f);
        animator1.setDuration(300);
        animator1.setInterpolator(new AccelerateDecelerateInterpolator());
        animator1.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                textView.setText("Searching...");
                textView.setAllCaps(true);
            }
        }, 300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility(View.GONE);
                start_fragment();
            }
        }, 1000);

    }

    private void initViews(View v) {
        imageView = (ImageView) v.findViewById(R.id.imageView);
        imageView1 = (ImageView) v.findViewById(R.id.imageView2);
        textView = (TextView) v.findViewById(R.id.progress_text);
        progressBar = (MaterialProgressBar) v.findViewById(R.id.progress_horizontal);
        button = (Button) v.findViewById(R.id.button);
        button_cancel = (Button) v.findViewById(R.id.button_cancel);
        textView.setText("Connecting...");
        textView.setAllCaps(true);
    }


    private void start_fragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new DashboardFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
