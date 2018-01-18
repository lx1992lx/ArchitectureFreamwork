package com.yyxk.architectureframework.center.data;

import android.os.Handler;
import android.os.Looper;

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
 * 包名:com.yyxk.architectureframework.center.data
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/1/17 下午1:57
 * 修改人：LX
 * 修改时间：2018/1/17 下午1:57
 * 修改备注：
 */

public class DataTaskExcuter{
    private static DataTaskExcuter mDataTaskExcuter;
    private Handler mHandler=new Handler(Looper.getMainLooper());

    private DataTaskExcuter() {
    }

    public static DataTaskExcuter getInstance(){
        if(mDataTaskExcuter==null)
            mDataTaskExcuter=new DataTaskExcuter();
        return mDataTaskExcuter;
    }

    public void postToMainThread(Runnable runnable){
        mHandler.post(runnable);
    }
}
