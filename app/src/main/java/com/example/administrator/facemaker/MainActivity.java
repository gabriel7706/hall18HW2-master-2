package com.example.administrator.facemaker;

import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener{
    //The Creation center
    protected RadioButton hair;
    protected RadioButton eyes;
    protected RadioButton skin;
    protected Spinner hairSpinner;
    protected Spinner eyesSpinner;
    protected Spinner noseSpinner;
    protected SeekBar redBar;
    protected SeekBar greenBar;
    protected SeekBar blueBar;
    protected Face faceDisplay;
    protected Button randomButton;
    protected TextView redLabel;
    protected TextView greenLabel;
    protected TextView blueLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //The initialization center
        skin = (RadioButton)findViewById(R.id.skinButton);
        eyes = (RadioButton)findViewById(R.id.eyesButton);
        hair = (RadioButton)findViewById(R.id.hairButton);

        hairSpinner = (Spinner)findViewById(R.id.hairSpinner);
        eyesSpinner = (Spinner)findViewById(R.id.eyesSpinner);
        noseSpinner = (Spinner)findViewById(R.id.noseSpinner);

        redBar = (SeekBar)findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(this);

        greenBar = (SeekBar)findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(this);

        blueBar = (SeekBar)findViewById(R.id.blueBar);
        blueBar.setOnSeekBarChangeListener(this);

        faceDisplay = (Face)findViewById(R.id.faceDisplay);

        randomButton = (Button)findViewById(R.id.randomButton);
        redLabel = (TextView)findViewById(R.id.redLabel);
        greenLabel = (TextView)findViewById(R.id.greenLabel);
        blueLabel = (TextView)findViewById(R.id.blueLabel);

        //David Carbonari showed me this in lab. I was clueless
        //This puts my array of hair choices in my hair spinner
        String[]hairSpinnerNames = getResources().getStringArray(R.array.hairspinner_values);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, hairSpinnerNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        hairSpinner.setAdapter(adapter);

        //duplicate for the eye spinner
        String[]eyesSpinnerNames = getResources().getStringArray(R.array.eyesspinner_values);

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, eyesSpinnerNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        eyesSpinner.setAdapter(adapter2);

        //and the nose spinner. Sounds gruesome
        String[]noseSpinnerNames = getResources().getStringArray(R.array.nosespinner_values);

        ArrayAdapter adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, noseSpinnerNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        noseSpinner.setAdapter(adapter3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(seekBar.getId() == R.id.redBar){
            seekBar.setMax(255);
            redLabel.setText("" + progress);
        }
        else if(seekBar.getId() == R.id.greenBar){
            seekBar.setMax(255);
            greenLabel.setText("" + progress);
        }
        else if(seekBar.getId() == R.id.blueBar){
            seekBar.setMax(255);
            blueLabel.setText("" + progress);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
