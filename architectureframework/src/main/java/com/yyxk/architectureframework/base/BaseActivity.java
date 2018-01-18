package com.yyxk.architectureframework.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.yyxk.architectureframework.center.manager.ActivityStackManager;
import com.yyxk.architectureframework.ibase.IBaseView;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：ArchFrameworkTest
 * 包名:com.yyxk.architectureframework.base
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/1/15 上午9:42
 * 修改人：LX
 * 修改时间：2018/1/15 上午9:42
 * 修改备注：
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    private String mPageName;
    private View mLayoutView;

    //初始化
    public abstract void init(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackManager.getInstance().push(this);
        mLayoutView = LayoutInflater.from(this).inflate(setLayoutId(),null);
        setContentView(mLayoutView);
        init(savedInstanceState);
    }

    public String getPageName() {
        return setPageName();
    }

    public View getLayoutView(){
        return mLayoutView;
    }

    @Override
    public <T extends BaseViewModel> T getViewModel(Class<T> clz) {
        T t = ViewModelProviders.of(this).get(clz);
        getLifecycle().removeObserver(t);
        getLifecycle().addObserver(t);
        return t;
    }

    @Override
    public <T extends BaseViewModel> T getViewModel(Class<T> clz, IBaseView iBaseView) {
        if (iBaseView instanceof AppCompatActivity) {
            T t = ViewModelProviders.of((AppCompatActivity) iBaseView).get(clz);
            getLifecycle().removeObserver(t);
            getLifecycle().addObserver(t);
            return t;
        } else if (iBaseView instanceof Fragment) {
            T t = ViewModelProviders.of((Fragment) iBaseView).get(clz);
            getLifecycle().removeObserver(t);
            getLifecycle().addObserver(t);
            return t;
        } else {
            throw new IllegalArgumentException("the second Argument(IBaseView) must be a AppCompatActivity or a Fragment(support v4)");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStackManager.getInstance().pop(this);
    }
}
