package com.yyxk.architectureframework.center.message;

import android.support.annotation.Nullable;

import com.yyxk.architectureframework.base.BaseViewModel;
import com.yyxk.architectureframework.center.manager.ViewModelManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
 * 包名:com.yyxk.architectureframework.center.message
 * 类描述：用于不同界面传递消息
 * 创建人：LX
 * 创建时间：2018/2/5 上午10:05
 * 修改人：LX
 * 修改时间：2018/2/5 上午10:05
 * 修改备注：
 */

public class MessageCenter {
    private static MessageCenter sCenter;

    private MessageCenter() {

    }

    public static MessageCenter getInstance() {
        if (sCenter == null)
            sCenter = new MessageCenter();
        return sCenter;
    }

    /**
     * 向所有 T 类型的ViewModel发送消息
     * @param event 事件标记
     * @param clz ViewModelClass
     * @param obj 传递参数
     */
    public <T extends BaseViewModel> void sendMsg(String event, Class<T> clz, @Nullable Object... obj) {
        Method method = findMethod(event, clz);
        if (method == null) {
            String exception = "did not found the method with annotation @OnMsgReceive(Event=" + event + ")";
            throw new MethodNotFoundException(exception);
        }
        ViewModelManager manager = ViewModelManager.getInstance();
        List<T> viewModels = manager.getAllViewModel(clz);
        invokeAllViewModelMethod(method, viewModels, obj);
    }

    /**
     * 执行全部的ViewModel中指定的Method
     */
    private void invokeAllViewModelMethod(Method method, List<? extends BaseViewModel> viewModels, Object... obj) {
        checkArgument(method,obj);//检查参数合法性
        for (BaseViewModel model : viewModels) {
            try {
                if (method.getParameterTypes().length == 0) {
                    method.invoke(model, null);
                }else{
                    method.invoke(model,obj);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 检查参数合法性
     */
    private void checkArgument(Method method, Object[] obj) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length!=obj.length)
            throw new IllegalArgumentException("parameters length not right,expect "+parameterTypes.length+",got "+obj.length);
        int length=parameterTypes.length;
        for (int i=0;i<length;i++){
            if (!parameterTypes[i].getName().equals(obj[i].getClass().getName())){
                throw new IllegalArgumentException("parameter type not right,expect "+parameterTypes[i].getName()+",got "+parameterTypes[i].getName());
            }
        }
    }

    /**
     * 找到指定Event的方法
     * @param event
     * @param clz
     * @return
     */
    private Method findMethod(String event, Class<? extends BaseViewModel> clz) {
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(OnMsgReceive.class)) {
                OnMsgReceive onMsgReceive = method.getAnnotation(OnMsgReceive.class);
                if (onMsgReceive.Event().equals(event)) {
                    return method;
                }
            }
        }
        return null;
    }


    private class MethodNotFoundException extends RuntimeException {
        public MethodNotFoundException(String message) {
            super(message);
        }
    }

}
