package com.yyxk.architectureframework.ibase;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.LayoutRes;

import com.yyxk.architectureframework.base.BaseViewModel;

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
 * 包名:com.yyxk.architectureframework.ibase
 * 类描述：
 * 创建人：LX
 * 创建时间：2017/12/28 下午5:19
 * 修改人：LX
 * 修改时间：2017/12/28 下午5:19
 * 修改备注：
 */

public interface IBaseView{
    Lifecycle getViewLifecycle();
    //设置布局文件Id
    @LayoutRes int setLayoutId();
    //设置页面名称
    String setPageName();
    //获取ViewModel
    <T extends BaseViewModel> T getViewModel(Class<T> clz);
    //获取指定的ViewModel
    <T extends BaseViewModel> T getViewModel(Class<T> clz,IBaseView iBaseView);

}
