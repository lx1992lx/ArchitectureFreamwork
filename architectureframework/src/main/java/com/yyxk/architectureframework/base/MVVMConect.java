package com.yyxk.architectureframework.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.yyxk.architectureframework.ibase.IBaseView;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
 * 类描述：View连接ViewModel类
 * 创建人：LX
 * 创建时间：2018/2/5 上午11:23
 * 修改人：LX
 * 修改时间：2018/2/5 上午11:23
 * 修改备注：
 */
class MVVMConect {

    private IBaseView mBandedView;

    private List<BaseViewModel> mViewModelList=new ArrayList<>();//存放声明的ViewModel对象


    /**
     * 获取一个ViewModel
     * @param clz
     * @param <T>
     * @return
     */
    public <T extends BaseViewModel> T getViewModel(Class<T> clz,IBaseView iBaseView) {
        T t=null;
        if(iBaseView instanceof BaseActivity) {
            t = ViewModelProviders.of((BaseActivity) iBaseView,createFactory(iBaseView)).get(clz);
        }else if(iBaseView instanceof BaseFragment){
            t = ViewModelProviders.of((BaseFragment) iBaseView,createFactory(iBaseView)).get(clz);
        }else{
            throw new IllegalArgumentException("error IBaseView sub type,the second Argument(IBaseView) must be a AppCompatActivity or a Fragment(support v4)");
        }
        mViewModelList.add(t);
        iBaseView.getViewLifecycle().removeObserver(t);
        iBaseView.getViewLifecycle().addObserver(t);
        return t;
    }



    public void onDestroy(){
        mViewModelList.clear();
        mViewModelList=null;
    }

    /**
     * 创建一个新MVVM工厂类
     */
    public MVVMFactory createFactory(IBaseView iBaseView){
        return new MVVMFactory(iBaseView);
    }

    /**
     * ViewModel工厂类
     */
    class MVVMFactory implements ViewModelProvider.Factory{

        private WeakReference<IBaseView> mWeakIBaseView;

        public MVVMFactory(IBaseView iBaseView) {
            mWeakIBaseView=new WeakReference<com.yyxk.architectureframework.ibase.IBaseView>(iBaseView);
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            T t=null;
            try {
                t = modelClass.getConstructor().newInstance();
                Method method=modelClass.getMethod("setIBaseView",IBaseView.class);
                method.invoke(t,mWeakIBaseView.get());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return t;
        }
    }
}
