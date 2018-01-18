# ArchitectureFreamwork
架构整体流程图：
  
###主要功能
<br>
项目根据google整合的Architecture架构，主要功能：<br>
1.耦合度低<br>
  每个ViewModel不依赖于特定的View，并且可以做到共享。<br>
2.可使整合其他框架（如网络框架，数据库框架等）简单<br>
  使用DataCenter作为处理数据的中心，ViewModel使用注解@OnDataReceive(Event="xxxx")方法接收数据的方式简单明了，整合进入其他框架十分轻松。<br>
3.ActivityStackManager管理Activity堆栈，可以获取指定Activity以共享ViewModel<br>
4.可进行二次封装<br>

