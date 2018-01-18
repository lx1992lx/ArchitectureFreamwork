package com.yyxk.archframeworktest.text1

import android.os.Bundle
import com.yyxk.archframeworktest.R
import com.yyxk.architectureframework.base.BaseActivity
import kotlinx.android.synthetic.main.activity_test1.*

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
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/1/15 上午11:05
 * 修改人：LX
 * 修改时间：2018/1/15 上午11:05
 * 修改备注：
 */
class Test1Activity: BaseActivity() {
    lateinit var mViewModel:Test1ViewModel

    override fun setLayoutId(): Int {
        return R.layout.activity_test1
    }

    override fun setPageName(): String {
        return "Test1Activity"
    }

    override fun init(savedInstanceState:Bundle?) {
        //1.获取ViewModel
        mViewModel=getViewModel(Test1ViewModel::class.java)
        mViewModel.context=this
        //2.初始化ViewModel中的数据，监听组件交给ViewModel
        mViewModel.createData(this,onDataChange ={textView.text=it?.name})
        //3.将逻辑操作交给ViewModel
        button.setOnClickListener {
            mViewModel.onButtonClicked()
        }
        //4.模拟联网等延时操作
        invoke.setOnClickListener{
            mViewModel.onInvokeClicked()
        }
        //5.跨线程操作
        thread_btn.setOnClickListener{
            mViewModel.onThreadClicked()
        }
    }

}