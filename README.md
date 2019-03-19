# DifferRepair
[![](https://img.shields.io/badge/platform-android-orange.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/language-java-yellow.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/Jcenter-1.1.4-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/license-apache--2.0-green.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/api-19+-green.svg)](https://github.com/hacknife)<br/><br/>
随着项目的迭代更新，功能越来越复杂，应用包也越来越庞大。 如果用户需要更新应用程序，则用户必须下载安装包，这导致一些用户无法在没有wifi的情况下及时更新应用程序。 因此，减小安装包的大小是很有必要的。DifferRepair能够生成体积小的差异包，然后差异包和移动端的应用包生成新的应用包。
## 使用说明

### 安装应用
```
        if (DifferUtils.haveUnknownAppInstallPermission(this)) {//检测高版本是否有安装未知应用权限
            DifferUtils.openUnknownAppInstallPermission(this);//打开安装未知应用的权限
        } else {
            DifferUtils.install(this, apkFile);//安装应用
        }
```
### 增量更新
根据旧版本应用与新版本应用生成差分补丁包，差分补丁包可与旧版本应用生成新版本应用。用户通过下载的差分补丁包(比完成的应用小很多)与旧版本应用(手机中系统会自动备份Apk)生成新版本应用，安装生成的应用达到升级的效果。
##### 生成补丁包
需要在linux环境下，执行如下命令，生成补丁包。
差异包需要在linux系统下生成，差异包生成工具中的jar文件和so文件必须放在同一目录下，点击[下载](https://raw.githubusercontent.com/hacknife/Differ/master/PatchTool.zip) tool 。
```
	java -jar differ.jar ./old.apk ./new.apk ./apk.patch
```

##### 根据本地安装的应用(旧应用)和新应用的补丁包生成新应用
```
    /*
     * oldfile: 本地安装的应用(旧应用) 常规操作：ApplicationInfo.sourceDir
     * newfile: 需要生成新应用(apk)
     * patchfile: 补丁包，通常从后台下载的。
     */
    Differ.repair(File oldfile,File newfile,File patchfile)
```

## 快速引入项目
```
dependencies {
	  implementation 'com.hacknife.differ:differ-java:1.1.4'
	  //optional abi
	  implementation 'com.hacknife.differ:differ-arm64:1.1.4'
	  implementation 'com.hacknife.differ:differ-armv7a:1.1.4'
	  implementation 'com.hacknife.differ:differ-armv5:1.1.4'
	  implementation 'com.hacknife.differ:differ-mips:1.1.4'
	  implementation 'com.hacknife.differ:differ-mips64:1.1.4'
	  implementation 'com.hacknife.differ:differ-x86:1.1.4'
	  implementation 'com.hacknife.differ:differ-x86_64:1.1.4'
}
```

<br><br><br>
## 感谢浏览
如果你有任何疑问，请加入QQ群，我将竭诚为你解答。欢迎Star和Fork本仓库，当然也欢迎你关注我。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/qq_group.png)
