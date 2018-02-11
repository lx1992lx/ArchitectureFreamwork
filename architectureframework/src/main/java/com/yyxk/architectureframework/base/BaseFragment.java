package com.yyxk.architectureframework.base;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    private View mLayoutView;
    public abstract void init();
    private MVVMConect mMVVMConect;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayoutView = LayoutInflater.from(getActivity()).inflate(setLayoutId(), container, false);
        initMvvmConect();
        init();
        return mLayoutView;
    }

    private void initMvvmConect() {
        mMVVMConect=new MVVMConect();
    }

    @Override
    public <T extends BaseViewModel> T getViewModel(Class<T> clz) {
        return mMVVMConect.getViewModel(clz,this);
    }

    @Override
    public <T extends BaseViewModel> T getViewModel(Class<T> clz, IBaseView iBaseView) {
        return mMVVMConect.getViewModel(clz,iBaseView);
    }

    /**
     * 获取PageName
     * @return
     */
    public String getPageName(){
        return setPageName();
    }

    public View getLayoutView(){
        return mLayoutView;
    }

    @Override
    public void onDestroy() {
        mMVVMConect.onDestroy();
        super.onDestroy();
    }

    @Override
    public Lifecycle getViewLifecycle() {
        return getLifecycle();
    }
}
