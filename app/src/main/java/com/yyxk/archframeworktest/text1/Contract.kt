package com.yyxk.archframeworktest.text1

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
 * 类描述：契约，不是必要
 * 创建人：LX
 * 创建时间：2018/1/15 上午11:08
 * 修改人：LX
 * 修改时间：2018/1/15 上午11:08
 * 修改备注：
 */
interface Contract {
    fun createData(activity: Test1Activity,onDataChange:(model:Test1Model?)->Unit)//创建livedata数据

    fun onButtonClicked()//按钮点击事件

    fun onInvokeClicked()//当发送事件时

    fun onThreadClicked()//线程
}