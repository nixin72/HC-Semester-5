package com.example.a1523066.pdumaresq_b51_a07;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter adapter = createAdapter();
        setListAdapter(adapter);
    }

    protected ListAdapter createAdapter() {
        final String[] Strings = getResources().getStringArray(R.array.options);
        ListAdapter adapter =
                new ArrayAdapter<String>(this, R.layout.list_layout, R.id.txtView, Strings);
        return adapter;
    }

    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
        switch (position) {
            case 0: {
                startActivity(new Intent(this, GetInformation.class));
            };
                break;
            case 1: {
                startActivity(new Intent(this, ShowInformation.class));
            };
                break;
            case 2: {
                startActivity(new Intent(this, About.class));
            };
                break;
            default: {

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}

