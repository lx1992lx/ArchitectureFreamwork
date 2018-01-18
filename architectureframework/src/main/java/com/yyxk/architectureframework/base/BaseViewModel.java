package com.yyxk.architectureframework.base;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModel;

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
 * 类描述：BaseViewModel,观察View的生命周期
 * 创建人：LX
 * 创建时间：2018/1/15 上午9:42
 * 修改人：LX
 * 修改时间：2018/1/15 上午9:42
 * 修改备注：
 */

public abstract class BaseViewModel extends ViewModel implements GenericLifecycleObserver{
    public boolean isActive;//判断ViewModel是否活动

    /**
     * 监听View生命周期
     * 当View的Destroy时，移除监听器
     * @param source
     * @param event
     */
    @Override
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        if(event== Lifecycle.Event.ON_RESUME){
            isActive=true;
        }else{
            isActive=false;
        }
        onViewStateChanged(source,event);
        if(Lifecycle.Event.ON_DESTROY==event){
            source.getLifecycle().removeObserver(this);
        }
    }

    public abstract void onViewStateChanged(LifecycleOwner source, Lifecycle.Event event);


}
