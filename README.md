# ArchitectureFreamwork
架构整体流程图：<br>
  ![image](https://github.com/lx1992lx/ArchitectureFreamwork/blob/master/demo.jpeg)
  
 <br>
 
 
主要功能
-----------


项目根据google整合的Architecture架构：<br>
1.耦合度低<br>
  每个ViewModel不依赖于特定的View，并且可以做到共享。<br>
2.可使整合其他框架（如网络框架，数据库框架等）简单<br>
  使用DataCenter作为处理数据的中心，ViewModel使用注解@OnDataReceive(Event="xxxx")方法接收数据的方式简单明了，整合进入其他框架十分轻松。<br>
3.ActivityStackManager管理Activity堆栈，可以获取指定Activity以共享ViewModel<br>
4.支持java和kotlin<br>
5.可进行二次封装<br>

使用方法
-----------
1.将architecturefreamwork的model导入项目中，并在你的项目添加该model的依赖<br>
2.使Activity和Fragment继承于BaseActivity或BaseFragment,并实现相关的方法<br>
3.使你的ViewModel继承BaseViewModel<br>
4.使用@OnDataReceive(Event="xxxx")注解，在ViewModel处理数据改变事件<br>
5.使用DataCenter.changeData()方法通知数据改变事件<br>
P.S.详细demo(Kotlin)请见app包下的test1包<br>


注意事项
-----------
推荐使用LiveData作为Model的承载体


<br>
<br>
邮箱：1012025958@qq.com
微信：lx1992lxlx
