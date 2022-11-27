package com.example.cinema.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.cinema.R;


public class CustomView  extends View {

    Matrix matrix;
    Bitmap bitmap;
    private int picHeight;
    private  int picWidth;
    private Picture picture;

    public int getPicWidth() {
        return picWidth;
    }

    public int getPicHeight() {
        return picHeight;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicWidth(int picWidth) {
        this.picWidth = picWidth;
    }

    public void setPicHeight(int picHeight) {
        this.picHeight = picHeight;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    private  void init(@Nullable AttributeSet set){

    }
    @Override
    protected void onDraw(Canvas canvas ){
        picWidth= 400;
        picHeight= 400;
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.m1);
        bitmap = Bitmap.createScaledBitmap(bitmap, picWidth, picHeight, false);
        matrix = new Matrix();
        matrix.postRotate(0);
        matrix.postTranslate(200, 180);
        canvas.drawBitmap(bitmap, matrix, null);
    }


}
