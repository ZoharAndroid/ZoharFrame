# ZoharFrame

Android 整体的基本框架，随着时间的推移，功能和效果会陆续的增多，在使用的时候，也可以根据说明来进行增删。
	
	注意：该框架的包名为：package="zzh.com.zoharframe"，到时候自己按公司要求进行修改。

## 一、 基本目录结构

### 1. activity ： activity页面

###2. fragment ： 所有的fragment

###3. utils : 工具

###4. widget : 自定义view

###5. base ： 基类

###6. adapter : 适配器

###7. application ： 整个框架的Application
	
	ZoharApplication ： 整个框架的Application

###8. model ： 对象

###9. config : 配置信息
	
	>	1、AppConfig ： App配置信息，如：网络地址等；
	>	2、Constants :  App中所有用到的一些常量信息,如：一些常量、Intent传递的Key等


##二、内容
  
#1、渐变进度条
###2017/8/2 17:16:10 
    
####（1）效果图

![](http://i.imgur.com/3CgrT0U.png)

####（2）样式文件(在/drwable文件下，新建一个pb_background.xml文件)

    <?xml version="1.0" encoding="utf-8"?>
	<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <!--ProgressBar的样式 -->

    <!-- 进度条的背景颜色 -->
    <item android:id="@android:id/background">
        <shape>

            <gradient
                android:angle="0"
                android:centerColor="#ffffff"
                android:centerY="0.75"
                android:endColor="#ffffff"
                android:startColor="#ffffff" />
        </shape>
    </item>

    <!-- 渐变色 -->
    <item android:id="@android:id/secondaryProgress">
        <clip>
            <shape>

                <gradient
                    android:angle="0"
                    android:centerColor="#4AEA2F"
                    android:centerY="0.75"
                    android:endColor="#31CE15"
                    android:startColor="#5FEC46" />
            </shape>
        </clip>
    </item>

    <!-- 默认开始结束颜色-->
    <item android:id="@android:id/progress">
        <clip>
            <shape>
                <gradient
                    android:angle="0"
                    android:endColor="#00ff00"
                    android:startColor="#ffffff" />
            </shape>
        </clip>
    </item>
	</layer-list>

####（3）布局文件
	  <ProgressBar
        android:id="@+id/pb_actiion_bar_progress"
        style="?android:attr/progressBarStyleHorizontal"
        android:layout_width="match_parent"
        android:layout_height="6dip"
        android:progressDrawable="@drawable/pb_background" <主要在是要把样式修改了>
        android:max="100"
        android:progress="0" />

