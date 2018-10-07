package com.hacknife.differrepair;

import java.io.File;

/**
 * Author: aliletter
 * Github: http://github.com/aliletter
 * Data: 2017/8/17.
 */

public class DifferRepair {

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
        System.loadLibrary("differrepair");
    }
}
