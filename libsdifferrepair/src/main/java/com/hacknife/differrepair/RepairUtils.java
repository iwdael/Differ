package com.hacknife.differrepair;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;


/**
 * Author: hacknife
 * Github: http://github.com/hacknife
 * Data: 2017/8/18.
 */

public class RepairUtils {

    public static void install(Context context, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static void uninstall(Context context, String packageName) {
        Uri uri = Uri.parse("package:" + packageName);
        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        context.startActivity(intent);
    }

    public static Uri uriFromFile(Context context,File file){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return FileProvider.getUriForFile(context,"com.hacknife.differrepair.FileProvider",file);
        }else{
            return  Uri.fromFile(file);
        }
    }

}
