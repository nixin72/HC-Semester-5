package com.example.a1523066.pdumaresq_b51_l06;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class BrowseInternet extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_internet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((Spinner) findViewById(R.id.spnWebsites)).setOnItemSelectedListener(this);
        findViewById(R.id.btnSearch).setOnClickListener(this);
        findViewById(R.id.imbHeritageLogo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSearch) {
            String url = ((EditText) findViewById(R.id.edtWebSite)).getText().toString();
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www." + url + ".com")));
        }
        else if (v.getId() == R.id.imbHeritageLogo) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cegep-heritage.qc.ca")));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Intent browser;
        switch (position) {
            case 0: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")); break;
            case 1: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com")); break;
            case 2: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")); break;
            case 3: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org")); break;
            case 4: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com")); break;
            case 5: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.reddit.com")); break;
            case 6: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com")); break;
            case 7: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.netflix.com")); break;
            case 8: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com")); break;
            case 9: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com")); break;
            default: {
                browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            }
        }
        startActivity(browser);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
