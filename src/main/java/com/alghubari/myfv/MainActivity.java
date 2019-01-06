package com.alghubari.myfv;

import android.content.Intent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.alghubari.myfv.data.FruitFragment;
import com.alghubari.myfv.data.PaperFragment;
import com.alghubari.myfv.data.VbFragment;
import com.alghubari.myfv.panel.ProductPanelActivity;

public class MainActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        // adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        // setUpViewPager();

       // TabLayout  tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
      //  tabLayout.getTabAt(0).setText("Fruit");


      //  tabLayout.setupWithViewPager(vpPager);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FruitFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return VbFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return PaperFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.men_main, menu);
        return true;

    }
    // This determines the title for each tab




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.product_page) {
            startActivity(new Intent(MainActivity.this,ProductPanelActivity.class));

            return true;
        }

        if (id == R.id.Custommer_page) {
            startActivity(new Intent(MainActivity.this,ProductPanelActivity.class));
            return true;
        }
        if (id == R.id.help) {
            startActivity(new Intent(MainActivity.this,ProductPanelActivity.class));
            return true;
           // Toast.makeText(this, "help page", Toast.LENGTH_LONG).show();
           // return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
