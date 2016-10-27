package net.macdidi.similar_LINE;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnClickListener {


    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    private List<Fragment> fragments;

    private LinearLayout ll_01;
    private LinearLayout ll_02;
    private LinearLayout ll_03;
    private LinearLayout ll_04;

    private ImageButton ll_01_img;
    private ImageButton ll_02_img;
    private ImageButton ll_03_img;
    private ImageButton ll_04_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        initView();

        initEvent();

        setSelect(0);
    }


    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Fragment fragment_01 = new Fragment_01();
        Fragment fragment_02 = new Fragment_02();
        Fragment fragment_03 = new Fragment_03();
        Fragment fragment_04 = new Fragment_04();

        fragments = new ArrayList<Fragment>();
        fragments.add(fragment_01);
        fragments.add(fragment_02);
        fragments.add(fragment_03);
        fragments.add(fragment_04);

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = viewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ll_01 = (LinearLayout) findViewById(R.id.ll_01);
        ll_02 = (LinearLayout) findViewById(R.id.ll_02);
        ll_03 = (LinearLayout) findViewById(R.id.ll_03);
        ll_04 = (LinearLayout) findViewById(R.id.ll_04);

        ll_01_img = (ImageButton) findViewById(R.id.ll_01_img);
        ll_02_img = (ImageButton) findViewById(R.id.ll_02_img);
        ll_03_img = (ImageButton) findViewById(R.id.ll_03_img);
        ll_04_img = (ImageButton) findViewById(R.id.ll_04_img);
    }


    private void initEvent() {
        ll_01.setOnClickListener(this);
        ll_02.setOnClickListener(this);
        ll_03.setOnClickListener(this);
        ll_04.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ll_01 :
                setSelect(0);
                break;

            case R.id.ll_02 :
                setSelect(1);
                break;

            case R.id.ll_03 :
                setSelect(2);
                break;

            case R.id.ll_04 :
                setSelect(3);
                break;
        }
    }


    private void setSelect(int i) {
        setTab(i);

        viewPager.setCurrentItem(i);

    }


    private void setTab(int i) {
        resetImg ();

        switch (i) {
            case 0:
                ll_01_img.setImageResource (R.drawable.i_01);

                break;

            case 1:
                ll_02_img.setImageResource (R.drawable.i_02);

                break;

            case 2:
                ll_03_img.setImageResource (R.drawable.i_03);

                break;

            case 3:
                ll_04_img.setImageResource (R.drawable.i_04);

                break;

        }
    }


    private void resetImg() {
        ll_01_img.setImageResource(R.drawable.g_01);
        ll_02_img.setImageResource(R.drawable.g_02);
        ll_03_img.setImageResource(R.drawable.g_03);
        ll_04_img.setImageResource(R.drawable.g_04);
    }
}
