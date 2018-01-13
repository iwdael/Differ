# DifferRepair  [![](https://jitpack.io/v/aliletter/differrepair.svg)](https://jitpack.io/#aliletter/differrepair)
As projects iterate, features become more complex and application packages grow larger and larger. If the user needs to update the application, the user must download the installation package, which makes some users unable to update the application in time without wifi. Therefore, it is necessary to reduce the size of the installation package. DifferRepair is able to generate small packets of difference, and then the difference packet and the mobile application packet generate a new application packet.[中文文档](https://github.com/aliletter/DifferRepair/blob/master/README_CHINESE.md)
## Instruction
Difference package needs to be generated in linux system. The jar file and the so file in the difference package builder must be in the same directory. Click on the [download](https://raw.githubusercontent.com/aliletter/DifferRepair/master/differrepair_tools.7z) tool.
### Method Description 
```Java
    /*
     * oldfile: apkfile which install in your device on current
     * newfile: akpfile which is non-exist,and will be combined by the method
     * patchfile: patchfile and oldfile are combine newfile
     */
    PackageUpdata.bspatch(File oldfile,File newfile,File patchfile)
```

### Linux Command 
```Java
	java -jar differrepair.jar ./old.apk ./new.apk ./apk.patch
```
## How to
To get a Git project into your build:
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories.   [click here for details](https://github.com/aliletter/CarouselBanner/blob/master/root_build.gradle.png)
```Java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### Step 2. Add the dependency
Add it in your application module build.gradle at the end of dependencies where you want to use.[click here for details](https://github.com/aliletter/CarouselBanner/blob/master/application_build.gradle.png)
```Java
	dependencies {
                ...
	        compile 'com.github.aliletter:differrepair:v1.0.3'
	}
```
### Step 3. Set JniLibs directory
Add it in your application module build.gradle.[click here for details](https://github.com/aliletter/gifengine/blob/master/jnilibs.png)
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
### Step 4. Add the permission
Add it in your application AndroidManifest.xml in the manifest label.   [click here for details](https://github.com/aliletter/OnHttp/blob/master/androimanifest.png)
```Java
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
### Step 5. Copy dynamic library file
Click [here](https://raw.githubusercontent.com/aliletter/DifferRepair/master/libs.7z) ,unzip and copy the files to your application libs directory.
[click here for details](https://github.com/aliletter/gifengine/blob/master/libs.png)
<br><br><br>
## Thank you for your browsing
If you have any questions, please join the QQ group. I will do my best to answer it for you. Welcome to star and fork this repository, alse follow me.
<br>
![Image Text](https://github.com/aliletter/CarouselBanner/blob/master/qq_group.png)
