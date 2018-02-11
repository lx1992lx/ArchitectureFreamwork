package com.yyxk.architectureframework.center.manager;

import com.yyxk.architectureframework.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 * 包名:com.yyxk.architectureframework.center.manager
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/5 上午9:57
 * 修改人：LX
 * 修改时间：2018/2/5 上午9:57
 * 修改备注：
 */

public class ViewModelManager {
    private Stack<BaseViewModel> mStack = new Stack<>();
    private static ViewModelManager mManager;

    private ViewModelManager() {
    }

    /**
     * 单例
     */
    public static ViewModelManager getInstance() {
        if (mManager == null)
            mManager = new ViewModelManager();
        return mManager;
    }

    public void push(BaseViewModel baseViewModel) {
        if (baseViewModel != null)
            mStack.push(baseViewModel);
    }

    public void pop() {
        mStack.pop();
    }


    public void remove(BaseViewModel baseViewModel) {
        if (baseViewModel != null)
            mStack.remove(baseViewModel);
    }

    /**
     * 获取该类下的所有ViewModel实例
     */
    public <T extends BaseViewModel> List<T> getAllViewModel(Class<T> clz) {
        List<T> models = new ArrayList<>();
        int size = mStack.size();
        for (int i = 0; i < size; i++) {
            if (mStack.get(i).getClass().getName().equals(clz.getName())) {
                models.add((T) mStack.get(i));
            }
        }
        return models;
    }
}

