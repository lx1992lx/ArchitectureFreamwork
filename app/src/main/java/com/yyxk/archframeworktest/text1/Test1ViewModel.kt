package com.yyxk.archframeworktest.text1

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.widget.Toast
import com.yyxk.architectureframework.base.BaseViewModel
import com.yyxk.architectureframework.center.data.DataCenter
import com.yyxk.architectureframework.center.data.OnDataReceive

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
 * 包名:com.yyxk.archframeworktest.text1
 * 类描述：ViewModel
 * 创建人：LX
 * 创建时间：2018/1/15 上午11:05
 * 修改人：LX
 * 修改时间：2018/1/15 上午11:05
 * 修改备注：
 */
class Test1ViewModel : BaseViewModel(), Contract {

    var context: Context? = null

    /**
     * 监听创建者（Activity）的生命周期
     */
    override fun onViewStateChanged(source: LifecycleOwner?, event: Lifecycle.Event?) {
        Toast.makeText(context,"state="+event,Toast.LENGTH_SHORT).show()
    }


    private var liveTest1Model = MutableLiveData<Test1Model>()

    /**
     * 创建LiveData数据
     */
    override fun createData(activity: Test1Activity, onDataChange: (model: Test1Model?) -> Unit) {
        liveTest1Model.value = Test1Model()
        liveTest1Model.value!!.name = activity.pageName
        liveTest1Model.observe(activity, Observer<Test1Model> {
            onDataChange(it)
        })
    }

    /**
     * 当按钮点击
     */
    override fun onButtonClicked() {
        val value = liveTest1Model.value
        value?.name = "Time=${System.currentTimeMillis()}"
        liveTest1Model.postValue(value)
    }

    /**
     * invoke按钮点击
     * 模拟当数据改变时的操作
     * （联网获取数据，数据库读取数据等）
     */
    override fun onInvokeClicked() {
        var test=Test1Model()
        test.name="invoke"
        DataCenter.getInstance().changeData(this,"1111",test)
    }


    /**
     * 线程改变并不影响,最后方法onDataChange()仍然是在主线程中执行的
     */
    override fun onThreadClicked() {
        Thread({
            var test=Test1Model()
            test.name="Thread"
            DataCenter.getInstance().changeData(this@Test1ViewModel,"1111",test)
        }).start()
    }

    /**
     * 数据改变
     */
    @OnDataReceive(Event = "1111")
    fun onDataChanged(test1Model: Test1Model) {
        liveTest1Model.postValue(test1Model)
    }


}