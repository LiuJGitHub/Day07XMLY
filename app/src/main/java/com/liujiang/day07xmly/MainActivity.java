package com.liujiang.day07xmly;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import Activitys.BaseActivity;
import Fragments.FindFragment;
import Fragments.MainFragment;
import Fragments.MineFragment;
import Fragments.PlayFragment;
import Fragments.SubscribeFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup_tabs;
    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment,mainFragment,subscribeFragment,playFragment,findFragment,mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();

        //1.获取Manager
        mFragmentManager=getSupportFragmentManager();
        mainFragment= new MainFragment(mFragmentManager);
        //2.显示首页
        mFragmentManager.beginTransaction()
                .add(R.id.frameLayout_container,mainFragment,"main")
                .commit();
        mCurrentFragment=mainFragment;
        radioGroup_tabs=(RadioGroup)findViewById(R.id.radioGroup_tabs);
        radioGroup_tabs.setOnCheckedChangeListener(this);
        radioGroup_tabs.check(R.id.main);

    }

    private void initFragment() {
        subscribeFragment=new SubscribeFragment();
        playFragment = new PlayFragment();
        findFragment=new FindFragment();
        mineFragment = new MineFragment();
    }

    private void initView() {
        radioGroup_tabs= (RadioGroup) findViewById(R.id.radioGroup_tabs);
    }


    private void showFragment(Fragment fragment, String tag) {
        if (fragment == null) {
            mFragmentManager.beginTransaction()
                    .hide(mCurrentFragment)
                    .add(R.id.frameLayout_container,fragment,tag)
                    .commit();
        }else {
            mFragmentManager.beginTransaction()
                    .hide(mCurrentFragment)
                    .show(fragment)
                    .commit();
        }
        mCurrentFragment=fragment;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main:
                mFragmentManager.beginTransaction()
                        .hide(mCurrentFragment)
                        .show(mainFragment)
                        .commit();
                mCurrentFragment = mainFragment;
                break;
            case R.id.subscribe:
                showFragment(subscribeFragment,"subscribe");
                break;
            case R.id.imageView_play:
                showFragment(playFragment, "play");
                break;
            case R.id.find:
                showFragment(findFragment,"find");
                break;
            case R.id.mine:
                showFragment(mineFragment, "main");
                break;

        }
    }

}
