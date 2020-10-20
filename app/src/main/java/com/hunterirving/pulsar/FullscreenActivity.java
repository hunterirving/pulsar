package com.hunterirving.pulsar;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import static android.os.Build.VERSION.SDK_INT;
import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

public class FullscreenActivity extends AppCompatActivity {

    @SuppressWarnings("deprecation")
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fullscreen);

        this.getWindow().getDecorView().setSystemUiVisibility(
                SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (SDK_INT >= Build.VERSION_CODES.P) {
            DisplayCutout displayCutout = this.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
            if (displayCutout != null) {
                List<Rect> bounding = displayCutout.getBoundingRects();
                for (int i=0; i<bounding.size(); i++) {
                    Log.e("BoundingRect - ", ""+bounding.get(i));
                }
            }
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}