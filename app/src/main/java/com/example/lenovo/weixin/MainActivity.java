package com.example.lenovo.weixin;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.example.lenovo.weixin.R.id.item_weixin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   // boolean isChange=false;

    private LinearLayout ly_message;
    private LinearLayout ly_contact;
    private LinearLayout ly_discovery;
    private LinearLayout ly_me;


   private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;
    private FragmentFouth fragmentFouth;
    private List<Fragment> fragmentList=new ArrayList<Fragment>();
    private FragmentAdapter fragmentAdapter;

    private android.
    support.v4.view.ViewPager vp;
   /* private TextView item_message;
    private TextView item_contact;
    private TextView item_discover;
    private TextView item_me;*/

    /*private ImageView im_message;
    private ImageView im_contact;
    private ImageView im_discover;
    private ImageView im_me;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.weixin);
        initViews();

        fragmentAdapter=new FragmentAdapter(this.getSupportFragmentManager(),fragmentList);
        vp.setAdapter(fragmentAdapter);
        vp.setCurrentItem(0);


        /*im_me=(ImageView) findViewById(R.id.im_me);
        im_message=(ImageView) findViewById(R.id.im_message);
        im_contact=(ImageView) findViewById(R.id.im_contact);
        im_discover=(ImageView) findViewById(R.id.im_discover);

        im_me.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(v==im_me){
                    if(isChange){
                        im_me.setImageDrawable(getResources().getDrawable(R.drawable.me));

                    }else{
                        im_me.setImageDrawable(getResources().getDrawable(R.drawable.me_active));
                        vp.setCurrentItem(3, true);
                    }

                }


            }


    });*/


        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {
                changeTextColor(position);
            }

            

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void initViews() {

        ly_message = (LinearLayout)findViewById(R.id.ly_message);
        ly_contact = (LinearLayout) findViewById(R.id.ly_contact);
        ly_discovery = (LinearLayout) findViewById(R.id.ly_discover);
        ly_me = (LinearLayout) findViewById(R.id.ly_me);

        ly_message.setOnClickListener(this);
        ly_contact.setOnClickListener(this);
        ly_discovery.setOnClickListener(this);
        ly_me.setOnClickListener(this);

        vp = (ViewPager) findViewById(R.id.mainViewPager);
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentThree = new FragmentThree();
        fragmentFouth = new FragmentFouth();
        //给FragmentList添加数据
        fragmentList.add(fragmentOne);
        fragmentList.add( fragmentTwo);
        fragmentList.add(fragmentThree);
        fragmentList.add(fragmentFouth);
    }


    private void changeTextColor(int position) {
        if (position == 0) {


        } else if (position == 1) {



        } else if (position == 2) {

        } else if (position == 3) {

        }
            }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.ly_message:
                vp.setCurrentItem(0, true);
                break;
            case R.id.ly_contact:
                vp.setCurrentItem(1, true);
                break;
            case R.id.ly_discover:
                vp.setCurrentItem(2, true);
                break;
            case R.id.ly_me:
                vp.setCurrentItem(3, true);
                break;
        }
    }
    public class FragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> mfragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> mfragmentList) {
            super(fm);
            this.mfragmentList = mfragmentList;
        }



        @Override
        public Fragment getItem(int position) {
            return mfragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mfragmentList.size();
        }

    }


}
