package com.hacknife.differ;

import java.io.File;

/**
 * Author: hacknife
 * Github: http://github.com/hacknife
 * Data: 2017/8/17.
 */

public class Differ {

    public static DifferStatus repair(String oldfile, String newfile, String patchfile) {
        return repair(new File(oldfile), new File(newfile), new File(patchfile));
    }

    public static DifferStatus repair(File oldfile, File newfile, File patchfile) {
        if (!oldfile.exists())
            return DifferStatus.OLDAPK_NON_EXIST;
        if (!patchfile.exists())
            return DifferStatus.PATCH_NON_EXIST;
        if (newfile.exists())
            return DifferStatus.NEWAPK_EXIST;
        patch(oldfile.getAbsolutePath(), newfile.getAbsolutePath(), patchfile.getAbsolutePath());
        return DifferStatus.SUCCESS;
    }


    private native static void patch(String oldfile, String newfile, String patchfile);

    static {
        System.loadLibrary("differ");
    }
}
