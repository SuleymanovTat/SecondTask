package ru.suleymanovtat.secondtask;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ru.suleymanovtat.secondtask.fragment.MainFragment;
import ru.suleymanovtat.secondtask.fragment.SearchFragment;
import ru.suleymanovtat.secondtask.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(MainFragment.newInstance());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int nameItemMenu = R.string.app_name;
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.actionSettings:
                nameItemMenu = R.string.settings;
                fragment = SettingsFragment.newInstance();
                break;
            case R.id.actionSearch:
                nameItemMenu = R.string.search;
                fragment = SearchFragment.newInstance();
                break;
            case R.id.actionExit:
                nameItemMenu = R.string.exit;
                finish();
                break;
            default:
                break;
        }
        showMessage(nameItemMenu);
        if (fragment != null)
            showFragment(fragment);
        return super.onOptionsItemSelected(item);
    }

    private void showMessage(int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment).addToBackStack("null")
                .commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();
        }
    }
}
