package com.qf.stroy.view;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * 抽取出来的View
 */
public interface ILoginActivityView {
    //登陆成功
    public void loginSuccess();
    //登陆失败
    public void loginFail();
    //设置头像的内容
    public void setPhoto(Bitmap bitmap);

}
