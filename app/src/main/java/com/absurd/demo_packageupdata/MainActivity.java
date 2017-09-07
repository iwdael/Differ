package com.absurd.demo_packageupdata;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.absurd.packageupdata.PackageUpdata;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsynUpdataTask().execute();
        File newfile = new File("/sdcard/Music/new.apk");
        //    PackageUtils.install(getApplicationContext(),newfile);
    }


    class AsynUpdataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            File oldfile = new File("/sdcard/Music/old.apk");
            File newfile = new File("/sdcard/Music/new.apk");
            File patchfile = new File("/sdcard/Music/apk.patch");
            if (oldfile.exists() && patchfile.exists()) {
                Log.v("TAG", "Combine Start!");
                PackageUpdata.bspatch(oldfile, newfile, patchfile);
                Log.v("TAG", "Combine End!");
            } else {
                Log.v("TAG", "File not exists! ");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
