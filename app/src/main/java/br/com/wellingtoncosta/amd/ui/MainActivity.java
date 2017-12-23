package br.com.wellingtoncosta.amd.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import br.com.wellingtoncosta.amd.R;
import br.com.wellingtoncosta.amd.databinding.ActivityMainBinding;
import br.com.wellingtoncosta.amd.ui.colors.ListColorsFragment;
import br.com.wellingtoncosta.amd.ui.users.ListUsersFragment;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }

    private void setupViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupToolbar();
        setupTabs();
    }

    private void setupToolbar() {
        if (binding.includeToolbar.toolbar != null) {
            setSupportActionBar(binding.includeToolbar.toolbar);
            ActionBar actionBar = getSupportActionBar();

            if (actionBar != null) {
                actionBar.setTitle(getString(R.string.app_name));
            }
        }
    }

    private void setupTabs() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new ListUsersFragment(), getString(R.string.users));
        adapter.addFragment(new ListColorsFragment(), getString(R.string.colors));

        binding.viewPager.setAdapter(adapter);
        binding.includeToolbar.tabs.setupWithViewPager(binding.viewPager);
    }

}