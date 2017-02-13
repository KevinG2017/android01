package com.qf.stroy.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.qf.stroy.R;
import com.qf.stroy.presenter.ILoginPresenter;
import com.qf.stroy.utils.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 登陆页面
 * 波波写的
 * 日期
 * MVP:抽取出来的是  view和control
 */
public class LoginActivity extends AppCompatActivity  implements ILoginActivityView{
    //图片的下载路径
    public static final String PATH="http://p.ishowx.com/uploads/allimg/161008/486-16100PU616.jpg";
    private EditText mUserName;     //用户名...
    private EditText mUserPwd;
    private Button mBtnLogin;
    private ImageView mImageViewPhoto;
    ILoginPresenter mLoginPresenter;
    ListView mListView;
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<File> lists=new ArrayList<>();
        lists.add(new File(Environment.getExternalStorageDirectory()+"/xiaobobo.png"));

        //测试那个OKhttpUtils
        OkHttpUtils.post(Util.sendStory)
                .params("uid","7030")
                .params("story_info","我有故事你有酒吗?")
                .params("userpass","ZWZmNmQwNmM1YmVlYTEzODZhMzY2YzIyYWFiOGVlY2I=")
                .params("userpass","ZWZmNmQwNmM1YmVlYTEzODZhMzY2YzIyYWFiOGVlY2I=")
                .params("lng","124.78")
                .params("lat","34.5")
                .params("city","大上海")
                .addFileParams("photo[]",lists)
//                .params("portrait",new File(Environment.getExternalStorageDirectory()+"/bobo.jpg"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.e("-------",s+"");
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Log.e("------------","你好!");
                    }
                });


//        mLoginPresenter=new LoginPresenter(LoginActivity.this,this);
//        init();
    }
    /**
     * 页面的初始化
     */
    private void init() {
        findView();
        setOnListener();
//        initData();

    }

    /**
     * 初始化数据
     */
    private void initData() {
           mLoginPresenter.setPhoto(PATH,mImageViewPhoto);
           mLoginPresenter.setAdapter(mListView);
    }

    /**
     * 设置监听
     */
    private void setOnListener() {
        mBtnLogin.setOnClickListener(new Listener());
//        mListView.setOnScrollListener(new MyOnScrollListener());
    }

    /**
     * ListView的滚动的监听
     */
    private class MyOnScrollListener implements AbsListView.OnScrollListener{
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            mLoginPresenter.controlImagviewLoadOrNot(scrollState);
            /**
             * ListView的baseAdapter中加载图片的时候
             * Picasso.with(LoginActivity.this).load("").tag(LoginActivity.this).into();
             *
             *
             *
             */
        }
        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();

    }
    @Override
    public void loginFail() {
         Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
    }

    /**
     * 设置头像的内容
     * @param bitmap
     */
    @Override
    public void setPhoto(Bitmap bitmap) {

//        Picasso.with(LoginActivity.this).load("").into(mImageViewPhoto);

        mImageViewPhoto.setImageBitmap(bitmap);
    }
    /**
     * 事件的处理
     */
    private class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
           switch (v.getId()){
               case R.id.mLoginBtnLogin:   //登陆
                  /* //获取UserName和Pwd的值
                   String userName=mUserName.getText().toString().trim();
                   String userPwd=mUserPwd.getText().toString().trim();
                   mLoginPresenter.login("",new User(userName,userPwd));*/


                   break;
           }
        }
    }

    /**
     * 找控件
     */
    private void findView() {
        mUserName= (EditText) findViewById(R.id.mLoginEdTUserName);
        mUserPwd= (EditText) findViewById(R.id.mLoginEdTUserPwd);
        mBtnLogin= (Button) findViewById(R.id.mLoginBtnLogin);
        mImageViewPhoto= (ImageView) findViewById(R.id.mImageViewPhoto);
    }
}
