package pku.miao.zhihudaily.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pku.miao.zhihudaily.R;
import pku.miao.zhihudaily.contract.ThemeContract;
import pku.miao.zhihudaily.presenter.ThemePresenter;
import pku.miao.zhihudaily.ui.fragment.RecommendFragment;
import pku.miao.zhihudaily.presenter.RecommendPresenter;
import pku.miao.zhihudaily.ui.fragment.ThemeFragment;
import pku.miao.zhihudaily.util.ActivityUtils;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int[] themeids = {13, 12, 3, 11, 4, 5, 6, 10, 2, 7, 9, 8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView();
    }

    void initView(){

        RecommendFragment recommendFragment = (RecommendFragment) getSupportFragmentManager()
                .findFragmentById(R.id.content_fl);

        if (recommendFragment == null) {
            recommendFragment = RecommendFragment.newInstance("recommend");
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    recommendFragment, R.id.content_fl);
        }
        new RecommendPresenter(recommendFragment);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.xlx:
                Fragment themeFragment = (Fragment) getSupportFragmentManager()
                        .findFragmentById(R.id.content_fl);

                if (themeFragment == null || !(themeFragment instanceof ThemeFragment)) {
                    themeFragment = ThemeFragment.newInstance("theme");
                    ActivityUtils.replaceFragment(getSupportFragmentManager(),
                            themeFragment, R.id.content_fl);
                }
                new ThemePresenter((ThemeContract.View) themeFragment, themeids[0]);
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
