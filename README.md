# packageupdata
PackageUpadata is a android framework which used to updata application for saving data traffic.
# How to
To get a Git project into your build:
## Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
## Step 2. Add the dependency

	dependencies {
	        compile 'com.github.mr-absurd:packageupdata:v1.0.2'
	}
## Step 3. Set JniLibs directory

```Java
android {
    ...
    sourceSets {
        main() {
            jniLibs.srcDirs = ['libs']
        }
    }
}

```
## Step 4. Copy dynamic library file
Click here [dynamic library file](https://github.com/mr-absurd/packageupdata/tree/master/app/libs) ,copy the files to your application.

<br><br><br>
#Methods Recommend
```Java
    /*
     * oldfile: apkfile which install in your device on current
     * newfile: akpfile which is non-exist,and will be combined by the method
     * patchfile: patchfile and oldfile are combine newfile
     */
    PackageUpdata.bspatch(File oldfile,File newfile,File patchfile)
```
