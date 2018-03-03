package com.example.pc.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends Fragment implements View.OnTouchListener {
    private String title;
    private int page;
    float startY, endY;

    public static ThirdFragment newInstance(int page, String title) {
        ThirdFragment fragmentFirst = new ThirdFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        TextView tvLabel = view.findViewById(R.id.text3);
        tvLabel.setText(page + " -- " + title);

        view.findViewById(R.id.frame3).setOnTouchListener(this);

        return view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY = event.getRawY() - v.getY();
                break;
            case MotionEvent.ACTION_UP:
                endY = event.getRawY() - v.getY();
                break;
        }
        doChange();
        return true;
    }

    private void doChange(){

        if (endY - startY > 0)
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .setCustomAnimations(R.anim.to_down, 0)
                    .replace(R.id.frame3, FirstFragment.newInstance(0, "Page # 1"))
                    .commit();

        if (endY - startY < 0)
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .setCustomAnimations(R.anim.to_up, 0)
                    .replace(R.id.frame3, SecondFragment.newInstance(1, "Page # 2"))
                    .commit();
    }
}
