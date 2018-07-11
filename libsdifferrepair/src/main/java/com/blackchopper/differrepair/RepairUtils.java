package com.blackchopper.differrepair;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;


/**
 * Author: mr-absurd
 * Github: http://github.com/mr-absurd
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

}
