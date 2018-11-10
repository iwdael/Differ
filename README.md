# DifferRepair [![](https://img.shields.io/badge/platform-android-orange.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/language-java-yellow.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/Jcenter-1.1.4-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/license-apache--2.0-green.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/api-19+-green.svg)](https://github.com/hacknife)<br/><br/>
随着项目的迭代更新，功能越来越复杂，应用包也越来越庞大。 如果用户需要更新应用程序，则用户必须下载安装包，这导致一些用户无法在没有wifi的情况下及时更新应用程序。 因此，减小安装包的大小是很有必要的。DifferRepair能够生成体积小的差异包，然后差异包和移动端的应用包生成新的应用包。[English](https://github.com/hacknife/DifferRepair/blob/master/README_ENGLISH.md)
## 使用说明
差异包需要在linux系统下生成，差异包生成工具中的jar文件和so文件必须放在同一目录下，点击[下载](https://raw.githubusercontent.com/hacknife/DifferRepair/master/differrepair_tools.7z) tool 。
### 方法说明 
```Java
    /*
     * oldfile: apkfile which install in your device on current
     * newfile: akpfile which is non-exist,and will be combined by the method
     * patchfile: patchfile and oldfile are combine newfile
     */
    DifferRepair.repair(File oldfile,File newfile,File patchfile)
```

### Linux 命令 
```Java
	java -jar differrepair.jar ./old.apk ./new.apk ./apk.patch
```
## 如何配置
将本仓库引入你的项目:
### Step 1. 添加JitPack仓库到Build文件
合并以下代码到项目根目录下的build.gradle文件的repositories尾。[点击查看详情](https://github.com/hacknife/CarouselBanner/blob/master/root_build.gradle.png)
```Java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### Step 2. 添加依赖   
合并以下代码到需要使用的application Module的dependencies尾。[点击查看详情](https://github.com/hacknife/CarouselBanner/blob/master/application_build.gradle.png)
```Java
	dependencies {
                ...
	        compile 'com.github.hacknife:differrepair:v1.0.3'
	}
```
### Step 3. 设置JniLibs目录
合并以下代码到你的application module的build.gradle。[点击查看详情](https://github.com/hacknife/gifengine/blob/master/jnilibs.png)
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
### Step 4. 添加权限
合并以下代码到应用的AndroidManifest.xml的manifest标签中。[点击查看详情](https://github.com/hacknife/OnHttp/blob/master/androimanifest.png)
```Java
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
### Step 5. 复制动态库文件
点击[这里](https://raw.githubusercontent.com/hacknife/DifferRepair/master/libs.7z) ,解压并复制文件到libs目录。[点击查看详情](https://github.com/hacknife/gifengine/blob/master/libs.png)
<br><br><br>
## 感谢浏览
如果你有任何疑问，请加入QQ群，我将竭诚为你解答。欢迎Star和Fork本仓库，当然也欢迎你关注我。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/qq_group.png)
