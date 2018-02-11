package com.yyxk.archframeworktest.test2

import android.os.Bundle
import com.yyxk.archframeworktest.R
import com.yyxk.architectureframework.base.BaseActivity
import kotlinx.android.synthetic.main.activity_test2.*

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
 * 创建时间：2018/2/5 上午10:42
 * 修改人：LX
 * 修改时间：2018/2/5 上午10:42
 * 修改备注：
 */
class Test2Activity:BaseActivity(){
    lateinit var mViewModel:Contract

    override fun setLayoutId(): Int {
        return R.layout.activity_test2
    }

    override fun setPageName(): String {
        return "Test2Activity"
    }

    override fun init(savedInstanceState: Bundle?) {
        mViewModel=getViewModel(Test2ViewModel::class.java)
        mViewModel.setActivity(this)
        button3.setOnClickListener {
            mViewModel.onButtonClick()
        }
    }

}