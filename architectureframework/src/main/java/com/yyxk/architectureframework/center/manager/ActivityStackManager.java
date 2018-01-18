package com.yyxk.architectureframework.center.manager;

import com.yyxk.architectureframework.base.BaseActivity;

import java.util.HashMap;
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
 * 创建时间：2018/1/16 下午2:27
 * 修改人：LX
 * 修改时间：2018/1/16 下午2:27
 * 修改备注：
 */

public class ActivityStackManager {
    private Stack<BaseActivity> mStack;
    private HashMap<String, Integer> mTagMap;
    private static ActivityStackManager mActivityManager;

    private ActivityStackManager() {
        mStack = new Stack<>();
        mTagMap = new HashMap<>();
    }

    /**
     * 单例
     *
     * @return
     */
    public static ActivityStackManager getInstance() {
        if (mActivityManager == null)
            mActivityManager = new ActivityStackManager();
        return mActivityManager;
    }

    /**
     * 推入一个Activity
     *
     * @param activity
     */
    public void push(BaseActivity activity) {
        String name = generateKey(activity);
        mTagMap.put(name, mStack.size());
        mStack.push(activity);
    }

    /**
     * 弹出一个Activity
     */
    public void pop() {
        BaseActivity pop = mStack.pop();
        mTagMap.remove(generateKey(pop));
    }

    /**
     * 弹出指定Activity
     *
     * @param baseActivity
     */
    public void pop(BaseActivity baseActivity){
        int index = mTagMap.get(generateKey(baseActivity));
        if (index != -1) {
            mStack.remove(index);
        }
    }

    /**
     * 一次性弹出所有Activity
     */
    public void finishAll() {
        int size = mStack.size();
        for (int i = 0; i < size; i++) {
            pop();
        }
    }

    /**
     * 获取栈顶Acitivty
     */
    public BaseActivity getLastActivity() {
        BaseActivity baseActivity = mStack.get(mStack.size() - 1);
        return baseActivity;
    }

    /**
     * 获取指定顺序的Activity
     *
     * @return
     */
    public BaseActivity getActivity(int position) {
        BaseActivity baseActivity = mStack.get(position);
        return baseActivity;
    }

    /**
     * 生成每个Activity对象独一无二的key
     *
     * @param activity
     * @return
     */
    private String generateKey(BaseActivity activity) {
        return activity.getClass().getName() + ":" + activity.hashCode();
    }
}
