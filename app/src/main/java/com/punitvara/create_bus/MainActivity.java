package com.punitvara.create_bus;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //make the screen full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //remove the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set the orientation as landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}


public class dowload_from_server extends AsyncTask<String, Void, Bitmap>
{
    ImageView bmImage;

    public dowload_from_server(ImageView bmImage)
    {
        this.bmImage = bmImage;
    }

    protected Bitmap inbackground(String... urls)
    {
        String urldisplay = urls[0];
        Bitmap bmp = null;

        try {
            InputStream in = new.java.net.URL(urldisplay).openstream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e)
        {
            Log.e ("Error", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }

    protected void OnPostExecute(Bitmap result)
    {
        bmImage.setImageBitmap(result);
    }
}