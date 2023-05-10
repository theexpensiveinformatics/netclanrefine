package krushang.netclanrefine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import krushang.netclanrefine.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {
    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);






        //status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.purple_500));

        //status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }



        //activityBinding
        activityHomeBinding =ActivityHomeBinding.inflate(getLayoutInflater());
        View view = activityHomeBinding.getRoot();
        setContentView(view);


        //default Fragment
        replaceFragment(new RefineFragment());

        activityHomeBinding.firstCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new RefineFragment());
                activityHomeBinding.firstImg.setImageResource(R.drawable.ic_refine_fill);
                activityHomeBinding.secondImg.setImageResource(R.drawable.ic_explore_out);
                _Animator(activityHomeBinding.firstCon,"scaleX",1,200);
                _Animator(activityHomeBinding.firstCon,"scaleY",1,200);
                _Animator(activityHomeBinding.secondCon,"scaleX",0.8,200);
                _Animator(activityHomeBinding.secondCon,"scaleY",0.8,200);
            }
        });

        activityHomeBinding.secondCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ExploreFramgment());
                activityHomeBinding.firstImg.setImageResource(R.drawable.ic_refine_out);
                activityHomeBinding.secondImg.setImageResource(R.drawable.ic_explore_fill);
                _Animator(activityHomeBinding.firstCon,"scaleX",0.8,200);
                _Animator(activityHomeBinding.firstCon,"scaleY",0.8,200);
                _Animator(activityHomeBinding.secondCon,"scaleX",1,200);
                _Animator(activityHomeBinding.secondCon,"scaleY",1,200);
            }
        });

        _Animator(activityHomeBinding.firstCon,"scaleX",1,200);
        _Animator(activityHomeBinding.secondCon,"scaleX",0.8,200);
        _Animator(activityHomeBinding.thirdCon,"scaleX",0.8,200);
        _Animator(activityHomeBinding.fourCon,"scaleX",0.8,200);
        _Animator(activityHomeBinding.fiveCon,"scaleX",0.8,200);
        _Animator(activityHomeBinding.firstCon,"scaleY",1,200);
        _Animator(activityHomeBinding.secondCon,"scaleY",0.8,200);
        _Animator(activityHomeBinding.thirdCon,"scaleY",0.8,200);
        _Animator(activityHomeBinding.fourCon,"scaleY",0.8,200);
        _Animator(activityHomeBinding.fiveCon,"scaleY",0.8,200);


        //animation Background

        LinearLayout bg = findViewById(R.id.homeBg);
        AnimationDrawable animationDrawable = (AnimationDrawable) bg.getBackground();
        animationDrawable.setEnterFadeDuration(700);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();


    }

    private  void replaceFragment(Fragment fragment)
    {

        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fragment_anim_2,R.anim.fragment_anim)
                .replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    //Animator Block
    public void _Animator (final View _view, final String _propertyName, final double _value, final double _duration) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.setTarget(_view);
        anim.setPropertyName(_propertyName);
        anim.setFloatValues((float)_value);
        anim.setDuration((long)_duration);
        anim.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
        anim.start();
    }

}