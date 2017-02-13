package com.qf.stroy.presenter.impl;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.qf.stroy.R;
import com.qf.stroy.dao.IUserDao;
import com.qf.stroy.dao.impl.UserDao;
import com.qf.stroy.entity.User;
import com.qf.stroy.presenter.ILoginPresenter;
import com.qf.stroy.view.ILoginActivityView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/**
 * Login的Presene
 */
public class LoginPresenter implements ILoginPresenter {
    //业务逻辑里面的代码
    IUserDao mIUserDao=new UserDao();
    ILoginActivityView mILoginActivityView;
    Context context;
    public LoginPresenter(Context context,ILoginActivityView mILoginActivityView){
        this.context=context;
        this.mILoginActivityView=mILoginActivityView;
    }
    @Override
    public boolean login(String url, User user) {
        //业务逻辑代码
        boolean result=mIUserDao.login("",new User(user.getUserName(),user.getUserPwd()));
        //和View相关的
        if(result){
            mILoginActivityView.loginSuccess();
        }else{
            mILoginActivityView.loginFail();
        }
        return false;
    }


    /**
     * 获取头像的内容
     * @param url
     * @return
     */
    @Override
    public void setPhoto(String url, ImageView mImageViewPhoto) {
        Log.e("-------------","我执行了......");
        //这个开启的是线程  异步任务  业务逻辑范畴的
        Picasso.with(context).load(url).into(mImageViewPhoto);
        //从中间裁剪占满整个控件
        Picasso.with(context).load(url).centerCrop().into(mImageViewPhoto);
        //表示下载失败的时候显示的图片
        Picasso.with(context).load(url).error(R.mipmap.ic_launcher).into(mImageViewPhoto);
        //图片旋转45读
        Picasso.with(context).load(url).rotate(45).into(mImageViewPhoto);
        //正在下载的时候展示的图片
        Picasso.with(context).load(url).placeholder(R.mipmap.ic_launcher).into(mImageViewPhoto);
        //设置了高的优先级  不一定先下载  只是获取下载的机会大一点而已
        Picasso.with(context).load(url).priority(Picasso.Priority.HIGH).into(mImageViewPhoto);
        //是否使用缓存的意思
        Picasso.with(context).load(url).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(mImageViewPhoto);

    }

    /**
     * 控制ListView加载图片与否
     * @param scrollSate
     */
    @Override
    public void controlImagviewLoadOrNot(int scrollSate) {
        //如果是暂停或者手指在上面触摸的时候
        if (scrollSate == AbsListView.OnScrollListener.SCROLL_STATE_IDLE || AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL == scrollSate) {
            Picasso.with(context).pauseTag(context);
        } else {
            Picasso.with(context).resumeTag(context);
        }
    }

    @Override
    public void setAdapter(ListView mListView) {
        MyAdapter adapter =new MyAdapter();
        mListView.setAdapter(adapter);
    }


    /**
     * 如果你认为adapter是业务逻辑处理的话那么  adapter应该写在这里
     */
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // 上面有很多的逻辑
            Picasso.with(context).load("").tag(context);
            return null;
        }
    }




}
