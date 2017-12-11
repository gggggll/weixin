package com.example.lenovo.weixin;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;




public class MainActivity extends FragmentActivity implements
        RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener,View.OnClickListener {

    //定义Fragment
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;
    //定义FragmentManager
    private FragmentManager fragmentManager;

    //定义组件
    private ViewPager viewPager;
    private List<Fragment> fragmentLists;
    private MyFragmentPagerAdapter adapter;
    private RadioGroup radioGroup;
    private RadioButton home; // 表示第一个RadioButton 组件
    private ImageView addBtn;
    private ImageView searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.weixin);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
        //初始化界面组件
        init();
        //初始化ViewPager
        initViewPager();

    }

    private void initViewPager() {
        fragment1 = new FragmentOne();
        fragment2 = new FragmentTwo();
        fragment3 = new FragmentThree();
        fragment4 = new FragmentFouth();

        fragmentLists = new ArrayList<Fragment>();
        fragmentLists.add(fragment1);
        fragmentLists.add(fragment2);
        fragmentLists.add(fragment3);
        fragmentLists.add(fragment4);
        //获取FragmentManager对象
        fragmentManager = getSupportFragmentManager();
        //获取FragmentPageAdapter对象
        adapter = new MyFragmentPagerAdapter(fragmentManager, fragmentLists);
        //设置Adapter，使ViewPager 与 Adapter 进行绑定
        viewPager.setAdapter(adapter);
        //设置ViewPager默认显示第一个View
        viewPager.setCurrentItem(0);
        //设置第一个RadioButton为默认选中状态
        home.setChecked(true);
        //ViewPager页面切换监听
        viewPager.addOnPageChangeListener(this);
    }

    private void init() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGrop);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        home = (RadioButton) findViewById(R.id.main_home);
        addBtn = (ImageView) this.findViewById(R.id.barAdd);
        searchBtn = (ImageView) this.findViewById(R.id.barSearch);

        addBtn.setOnClickListener(this);
        searchBtn.setOnClickListener(this);
        //RadioGroup状态改变监听

        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_home: // 首页
                //显示第一个Fragment并关闭动画效果
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.main_tuan: // 团购
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.main_search: // 发现
                viewPager.setCurrentItem(2, false);
                break;
            case R.id.main_my: // 我的
                viewPager.setCurrentItem(3, false);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    /**
     * ViewPager切换Fragment时，RadioGroup做相应的监听
     */
    @Override
    public void onPageSelected(int arg0) {
        switch (arg0) {
            case 0:
                radioGroup.check(R.id.main_home);
                break;
            case 1:
                radioGroup.check(R.id.main_tuan);
                break;
            case 2:
                radioGroup.check(R.id.main_search);
                break;
            case 3:
                radioGroup.check(R.id.main_my);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.barAdd:
                Toast.makeText(MainActivity.this, "你点击了添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.barSearch:
                Toast.makeText(MainActivity.this, "你点击了搜索", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
