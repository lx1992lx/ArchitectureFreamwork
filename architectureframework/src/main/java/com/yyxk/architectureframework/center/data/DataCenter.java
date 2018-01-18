package com.yyxk.architectureframework.center.data;

import com.yyxk.architectureframework.base.BaseViewModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
 * 包名:com.yyxk.architectureframework.datacenter
 * 类描述：数据分发中心
 * 创建人：LX
 * 创建时间：2018/1/15 下午3:51
 * 修改人：LX
 * 修改时间：2018/1/15 下午3:51
 * 修改备注：
 */

public class DataCenter {
    private static DataCenter mDataCenter;

    private DataCenter() {
    }

    /**
     * 单例
     * @return DataCenter单例对象
     */
    public static DataCenter getInstance(){
        if(mDataCenter==null)
            mDataCenter=new DataCenter();
        return mDataCenter;
    }

    /**
     * 通知改变数据
     * @param baseViewModel ViewModel
     * @param event 事件Tag
     * @param data 数据对象
     * @param <T> 任意类型
     */
    public <T> void changeData(BaseViewModel baseViewModel,String event,T data){
        Method[] methods = baseViewModel.getClass().getMethods();
        for (Method method:methods){
            if(method.isAnnotationPresent(OnDataReceive.class)){
                OnDataReceive onDataReceive = method.getAnnotation(OnDataReceive.class);
                if(onDataReceive.Event().equals(event)){
                    doInMainThread(method,baseViewModel,data);//在主进程里执行方法
                }
            }
        }
    }

    /**
     * 切换到主进程里执行
     * @param method
     * @param baseViewModel
     * @param data
     * @param <T>
     */
    private <T> void doInMainThread(final Method method, final BaseViewModel baseViewModel, final T data){
        DataTaskExcuter.getInstance().postToMainThread(new Runnable() {
            @Override
            public void run() {
                invokeMethod(method,baseViewModel,data);
            }
        });
    }

    /**
     * 调用方法
     */
    private <T> void invokeMethod(Method method,BaseViewModel baseViewModel,T data) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if(parameterTypes.length!=1){
            throw new RuntimeException("the ("+method.getName()+") method must has only one parameter： "+data.getClass());
        }
        try {
            method.invoke(baseViewModel,data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
