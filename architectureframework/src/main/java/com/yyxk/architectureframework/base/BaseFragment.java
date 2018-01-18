package com.yyxk.architectureframework.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * 创建时间：2018/1/15 上午10:20
 * 修改人：LX
 * 修改时间：2018/1/15 上午10:20
 * 修改备注：
 */

public abstract class BaseFragment extends Fragment implements IBaseView {

    public abstract void init();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layoutView = LayoutInflater.from(getActivity()).inflate(setLayoutId(), container, false);
        init();
        return layoutView;
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

    /**
     * 获取PageName
     * @return
     */
    public String getPageName(){
        return setPageName();
    }
}
