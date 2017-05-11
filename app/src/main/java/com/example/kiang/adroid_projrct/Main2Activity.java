package com.example.kiang.adroid_projrct;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    public EditText X,Y;
    public ImageView IV;
    public ConstraintLayout CL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        X = (EditText)findViewById(R.id.editText);
        Y = (EditText)findViewById(R.id.editText2);
        IV = (ImageView)findViewById(R.id.imageView);
        CL = (ConstraintLayout)findViewById(R.id.screen);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        Button Submit = (Button)findViewById(R.id.button);

        Submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();
        IV.setX(10000);
        IV.setY(10000);
        try
        {
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN: X.setText(""+x);Y.setText(""+y);IV.setX(x-50);IV.setY(y-270);break;
                case MotionEvent.ACTION_UP:X.setText(""+x);Y.setText(""+y);break;
                case MotionEvent.ACTION_MOVE:X.setText(""+x);Y.setText(""+y);IV.setX(x-50);IV.setY(y-270);break;
            }
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

}
