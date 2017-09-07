/**
 * Author: mr-absurd
 * Github: http://github.com/mr-absurd
 * Data: 2017/8/17.
 */
#include "com_absurd_packageupdata_PackageUpdata.h"
#include "bspatch.c"
JNIEXPORT void JNICALL Java_com_absurd_packageupdata_PackageUpdata_patch(JNIEnv *env, jclass type, jstring oldfile_, jstring newfile_, jstring patchfile_) {
       const char *oldfile = env->GetStringUTFChars(oldfile_, 0);
       const char *newfile = env->GetStringUTFChars(newfile_, 0);
       const char *patchfile = env->GetStringUTFChars(patchfile_, 0);
       char *argv[4];
       argv[0] =(char *) "bsdiff";
       argv[1] = (char *) oldfile;
       argv[2] = (char *) newfile;
       argv[3] = (char *) patchfile;
       bspatch_main(4, argv);
       env->ReleaseStringUTFChars(oldfile_, oldfile);
       env->ReleaseStringUTFChars(newfile_, newfile);
       env->ReleaseStringUTFChars(patchfile_, patchfile);
}