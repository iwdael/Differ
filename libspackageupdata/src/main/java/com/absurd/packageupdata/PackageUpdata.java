package com.absurd.packageupdata;

import java.io.File;

/**
 * Author: mr-absurd
 * Github: http://github.com/mr-absurd
 * Data: 2017/8/17.
 */

public class PackageUpdata {
    public static UpdataStatus bspatch(File oldfile, File newfile, File patchfile) {
        if (!oldfile.exists())
            return UpdataStatus.OLDAPK_NON_EXIST;
        if (!patchfile.exists())
            return UpdataStatus.PATCH_NON_EXIST;
        if (newfile.exists())
            return UpdataStatus.NEWAPK_EXIST;
        patch(oldfile.getAbsolutePath(), newfile.getAbsolutePath(), patchfile.getAbsolutePath());
        return UpdataStatus.SUCCESS;

    }

    private native static void patch(String oldfile, String newfile, String patchfile);

    static {
        System.loadLibrary("packageupdata");
    }
}
