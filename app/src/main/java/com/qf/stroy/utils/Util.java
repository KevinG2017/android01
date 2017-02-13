package com.qf.stroy.utils;

/**
 * 系统的配置和默认的常量
 */
public class Util {
    private static  String basePath="http://139.129.19.51/story";   //跟地址
    private static String projectPath="/index.php/home/Interface/";        //项目路径
    private static String basePhoto="/Uploads/portrait/";

    /*访问头像的地址*/
   // http://139.129.19.51/story/Uploads/portrait/20170118/587ee56130c7a.jpg
    public static String protrit=basePath+basePhoto+"20170118/587ee56130c7a.jpg";
    /*具体的接口*/
    public static  String login=basePath+projectPath+"login"; //最终的注册的地址
    public static String register=basePath+projectPath+"regist"; //最终的登陆的地址
    public static String sendStory=basePath+projectPath+"sendStory"; //最终的登陆的地址


}
