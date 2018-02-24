package ru.suleymanovtat.secondtask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int nameItemMenu = R.string.app_name;
        switch (item.getItemId()) {
            case R.id.actionSettings:
                nameItemMenu = R.string.settings;
                break;
            case R.id.actionSearch:
                nameItemMenu = R.string.search;
                break;
            case R.id.actionExit:
                nameItemMenu = R.string.exit;
                break;
            default:
                break;
        }
        showMessage(nameItemMenu);
        return super.onOptionsItemSelected(item);
    }

    private void showMessage(int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }
}
