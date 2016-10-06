## 如何修改配置，达到修改程序
在上一家公司，通过修改xml来实现：
- Q1:如何修改内存中的xml
- Q2:修改xml是不是应该通过API控制比较好
- Q3:Nginx和Kong如何修改conf控制插件，难道每次都读一遍conf，感觉不合理
    使用fileListener来监控file，而filerListen的实现是monitor线程每1000ms去扫描一遍，同时使用file比较器来检查
