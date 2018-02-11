package com.yyxk.archframeworktest.test2

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import com.yyxk.archframeworktest.text1.Test1ViewModel
import com.yyxk.architectureframework.base.BaseViewModel
import com.yyxk.architectureframework.center.message.MessageCenter

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
 * 包名:com.yyxk.archframeworktest.test2
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/5 下午2:23
 * 修改人：LX
 * 修改时间：2018/2/5 下午2:23
 * 修改备注：
 */
class Test2ViewModel:BaseViewModel(),Contract{
    private lateinit var mActivity:Test2Activity

    override fun setActivity(activity: Test2Activity) {
        mActivity=activity
    }

    override fun onButtonClick() {
        MessageCenter.getInstance().sendMsg("2222", Test1ViewModel::class.java,"a")
        mActivity.finish()
    }

    override fun onViewStateChanged(source: LifecycleOwner?, event: Lifecycle.Event?) {

    }



}