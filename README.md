# 社区后台开发
## 1、开发社区首页
* 开发流程
  * 1次请求的执行过程
* 分布实现
  * 开发社区首页，显示前10个帖子
  * 开发分页组件，分页显示所有的帖子
## 2、调试技巧（一定要学会呀。。。）
* 响应状态码含义
  * 2**：成功
  * 3**：重定向，资源位置发生变动，需要客户端重新发送请求；重定向：以一个非常低的耦合的方式进行<br>
         功能之间的跳转（如：注册完后直接跳到登录页面）
  * 4**：客户端错误，请求报文有误，服务器无法处理
  * 5**：服务端错误，服务器在处理请求时内部发生错误
* 服务端调试技巧：设置断点（F7，F8）
* 客户端调试技巧：检查（F10,F11）
* 设置日志级别，并将日志输出到不同的终端<br>
  springboot支持各种各样的记录日志的工具（默认：logback）,不同的方法代表不同的日志级别<br>
  ```java
  package org.slf4j; 
  public interface Logger {

  // Printing methods: 
  public void trace(String message);
  public void debug(String message);
  public void info(String message); 
  public void warn(String message); 
  public void error(String message); 
  }
  ```
## 3、版本控制
通常使用git进行版本控制<br>
* 账号配置<br>
```java
git -config --list
git -config --global user.name "Wz0503"
git -config --global user.email "13508603073wz@sina.com"
```
* 本地仓库
```java
git init
git status -s
git add *
git commit -m '...'
```
* 生成密钥
```java
ssh-keygen -t rsa -C "13508603073wz@sina.com"
```
* 推送已有项目
```java
git remote add origin https://..../.git
git push -u origin master
```
* 克隆已有仓库
```java
git clone https://.../.git
```
