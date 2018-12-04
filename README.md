# DifferRepair
[![](https://img.shields.io/badge/platform-android-orange.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/language-java-yellow.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/Jcenter-1.1.4-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/license-apache--2.0-green.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/api-19+-green.svg)](https://github.com/hacknife)<br/><br/>
随着项目的迭代更新，功能越来越复杂，应用包也越来越庞大。 如果用户需要更新应用程序，则用户必须下载安装包，这导致一些用户无法在没有wifi的情况下及时更新应用程序。 因此，减小安装包的大小是很有必要的。DifferRepair能够生成体积小的差异包，然后差异包和移动端的应用包生成新的应用包。
## 使用说明
差异包需要在linux系统下生成，差异包生成工具中的jar文件和so文件必须放在同一目录下，点击[下载](https://raw.githubusercontent.com/hacknife/DifferRepair/master/differrepair_tools.7z) tool 。
### 方法说明
##### 安装应用
```
        if (RepairUtils.haveUnknownAppInstallPermission(this)) {//检测高版本是否有安装未知应用权限
            RepairUtils.openUnknownAppInstallPermission(this);//打开安装未知应用的权限
        } else {
            RepairUtils.install(this, apkFile);//安装应用
        }
```
##### 根据本地安装的应用(旧应用)和新应用的补丁包生成新应用
```
    /*
     * oldfile: 本地安装的应用(旧应用) 常规操作：ApplicationInfo.sourceDir
     * newfile: 需要生成新应用(apk)
     * patchfile: 补丁包，通常从后台下载的。
     */
    DifferRepair.repair(File oldfile,File newfile,File patchfile)
```
##### 生成补丁包
需要在linux环境下，执行如下命令，生成补丁包。
```
	java -jar differrepair.jar ./old.apk ./new.apk ./apk.patch
```
## 如何配置
### Step 1. 添加依赖   
合并以下代码到需要使用的module的dependencies尾。
```
	dependencies {
                ...
	        compile 'com.hacknife:differrepair:1.1.4'
	}
```
### Step 2. 设置JniLibs目录(如果需要通过补丁包生成新应用)
合并以下代码到你的application module的build.gradle。
```
android {
    ...
    sourceSets {
        main() {
            jniLibs.srcDirs = ['libs']
        }
    }
}

```
### Step 3. 添加权限
合并以下代码到应用的AndroidManifest.xml的manifest标签中。
```
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
```
### Step 4. 复制动态库文件(如果需要通过补丁包生成新应用)
点击[这里](https://raw.githubusercontent.com/hacknife/DifferRepair/master/libs.7z) ,解压并复制文件到libs目录。
<br><br><br>
## 感谢浏览
如果你有任何疑问，请加入QQ群，我将竭诚为你解答。欢迎Star和Fork本仓库，当然也欢迎你关注我。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/qq_group.png)
