package com.imdevil.slackfish;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.imdevil.slackfish.bean.BoringPicsResponse;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author i-mde
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final String[] TABS = {"妹子图", "无聊图"};
    private List<BaseFragment> fragments = Arrays.asList(FunnyPicFragment.instance("妹子图"), GirlFragment.instance("无聊图"));
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private Handler mHandler = new Handler();
    private String reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mTabLayout = findViewById(R.id.tablayout);
        mViewPager = findViewById(R.id.viewpager);

        for (String title : TABS) {
            mTabLayout.addTab(mTabLayout.newTab().setText(title));
        }

        mViewPager.setAdapter(new FragmentStateAdapter(getSupportFragmentManager(), getLifecycle()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments.get(position);
            }

            @Override
            public int getItemCount() {
                return fragments.size();
            }
        });

        TabLayoutMediator mediator = new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(TABS[position]);
            }
        });
        mediator.attach();

        todoNetWork();
    }

    private void todoNetWork() {
        String pic = "https://i.jandan.net/?oxwlxojflwblxbsapi=jandan.get_pic_comments&page=1";
        final Gson gson = new Gson();
        OkHttpClient mClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(pic)
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                reponse = response.body().string();
                Log.d(TAG, "onResponse: " + reponse);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        BoringPicsResponse pics = gson.fromJson(reponse, BoringPicsResponse.class);
                        Log.d(TAG, "onResponse: " + pics.getStatus());
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}