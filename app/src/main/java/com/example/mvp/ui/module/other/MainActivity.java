package com.example.mvp.ui.module.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.ui.module.home.activity.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.skip)
    Button skip;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_main);
        animation.setDuration(3000);
        animation.setAnimationListener(this);

        tv.startAnimation(animation);
        img.startAnimation(animation);


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @OnClick(R.id.skip)
    public void onViewClicked() {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
