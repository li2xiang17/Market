package com.example.market;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.market.fragment.ClassificationFragment;
import com.example.market.fragment.HomeFragment;
import com.example.market.fragment.MineFragment;
import com.example.market.fragment.ShoppingFragment;
import com.example.market.fragment.SpecialFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout mFragment;
    private RadioGroup mRgMain;
    private RadioButton mRbHomeMain;
    private RadioButton mRbSpecialMain;
    private RadioButton mRbClassifyMain;
    private RadioButton mRbShopcalMain;
    private RadioButton mRbMyMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        mFragment = (FrameLayout) findViewById(R.id.fragment);
        mRgMain = (RadioGroup) findViewById(R.id.rg_main);
        mRbHomeMain = (RadioButton) findViewById(R.id.rb_home_main);
        mRbSpecialMain = (RadioButton) findViewById(R.id.rb_special_main);
        mRbClassifyMain = (RadioButton) findViewById(R.id.rb_classify_main);
        mRbShopcalMain = (RadioButton) findViewById(R.id.rb_shopcal_main);
        mRbMyMain = (RadioButton) findViewById(R.id.rb_my_main);

        mRgMain.setOnCheckedChangeListener(this);
        mRbHomeMain.setChecked(true);
        HomeFragment homeFragment = new HomeFragment();
        androidx.fragment.app.FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment,homeFragment)
                .commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_home_main:
                androidx.fragment.app.FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new HomeFragment()).commit();
                break;

            case R.id.rb_special_main:
                androidx.fragment.app.FragmentManager supportFragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.fragment,new SpecialFragment()).commit();

                break;

            case R.id.rb_classify_main:
                androidx.fragment.app.FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = supportFragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.fragment,new ClassificationFragment()).commit();
                break;

            case R.id.rb_shopcal_main:
                androidx.fragment.app.FragmentManager supportFragmentManager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = supportFragmentManager3.beginTransaction();
                fragmentTransaction3.replace(R.id.fragment,new ShoppingFragment()).commit();
                break;

            case R.id.rb_my_main:
                androidx.fragment.app.FragmentManager supportFragmentManager4 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction4 = supportFragmentManager4.beginTransaction();
                fragmentTransaction4.replace(R.id.fragment,new MineFragment()).commit();
                break;
        }
    }

}