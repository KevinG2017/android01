package com.qf.stroy.presenter;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;
import android.widget.ListView;

import com.qf.stroy.entity.User;

/**
 * Created by apple on 2017/1/16.
 */
public interface ILoginPresenter {
    public boolean login(String url, User user);
    public void setPhoto(String url, ImageView mImageViewPhoto);
    public void controlImagviewLoadOrNot(int scrollSate);
    public void setAdapter(ListView mlistView);
}
