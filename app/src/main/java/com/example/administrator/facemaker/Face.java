package com.example.administrator.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by hall18 on 2/10/2016.
 */
public class Face extends SurfaceView{

    protected int[] skinColor = {0, 0, 0};
    protected int[] eyeColor = {0, 0, 0};
    protected int[] hairColor = {0, 0, 0};
    protected int hairStyleIndex;
    protected int eyeStyleIndex;
    protected int noseStyleIndex;


    public Face(Context context) {
        super(context);

    }

    //David helped me with these next two methods
    public Face (Context context, AttributeSet attrs ){
        super(context, attrs);
        setWillNotDraw(false);
    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
    }

    public void randomize() {
        Random rand = new Random();
        skinColor[0] = rand.nextInt(256);
        skinColor[1] = rand.nextInt(256);
        skinColor[2] = rand.nextInt(256);

        eyeColor[0] = rand.nextInt(256);
        eyeColor[1] = rand.nextInt(256);
        eyeColor[2] = rand.nextInt(256);

        hairColor[0] = rand.nextInt(256);
        hairColor[1] = rand.nextInt(256);
        hairColor[2] = rand.nextInt(256);

        hairStyleIndex = rand.nextInt(3);

        eyeStyleIndex = rand.nextInt(3);

        noseStyleIndex = rand.nextInt(3);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Paint facePaint = new Paint();
        facePaint.setColor(0xFFFAE7D0);
        int faceRadius = 300;
        int faceX = 315;
        int faceY = 550 ;
        canvas.drawCircle(faceX, faceY, faceRadius, facePaint);

        Paint pupils = new Paint();
        pupils.setColor(0xff000000);

        Paint irisPaint = new Paint();
        irisPaint.setColor(0xFFFF0000);
        int irisRadius = 35;
        int lIrisX = 200;
        int lIrisY = 415;
        canvas.drawCircle(lIrisX, lIrisY, irisRadius, irisPaint);
        int rIrisX = 400;
        int rIrisY = 415;
        canvas.drawCircle(rIrisX, rIrisY, irisRadius, irisPaint);

        int pupilRadius = 15;
        int lPupilX = 200;
        int lPupilY = 415;
        canvas.drawCircle(lPupilX, lPupilY, pupilRadius, pupils );
        int rPupilX = 400;
        int rPupilY = 415;
        canvas.drawCircle(rPupilX, rPupilY, pupilRadius, pupils);

    }
}

