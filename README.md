# 社区后台开发
## 开发社区首页
* 开发流程
  * 1次请求的执行过程
* 分布实现
  * 开发社区首页，显示前10个帖子
  * 开发分页组件，分页显示所有的帖子
### 1、调试技巧（一定要学会呀。。。）
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
### 2、版本控制
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
## 开发社区登录模块
### 1、发送邮件
* 邮箱设置
  * 启用客户端SMTP服务
* Spring Email
  * 导入jar包
  * 邮箱参数配置
  ```java
  # 邮箱域名
  spring.mail.host=SMTP.sina.com
  spring.mail.port=465
  spring.mail.username=13508603073wz@sina.com
  spring.mail.password=690856250c480bf5(密码使用开启SMTP服务后的授权码)
  spring.mail.protocol=smtps
  # 采用ssl安全连接
  spring.mail.properties.mail.smtp.ssl.enable=true
  ```
  * 使用JavaMailSender发送邮件
* 模板引擎
  * 使用Thymeleaf发送HTML邮件
### 2、开发注册功能
* 访问注册页面
  * 点击顶部区域内的链接，打开注册页面
* 提交注册数据
  * 通过表单提交数据
  * 服务端验证账号是否已经存在，邮箱是否已注册
  * 服务端发送激活邮件
* 激活注册账号
  * 点击邮件中的链接，访问服务端的激活服务
### 3、会话管理
* HTTP的基本性质
  * http是简单的
  * http是可扩展的
  * http是无状态的，有会话的
* Cookie
  * 是服务端发送到浏览器，并保存在浏览器端的一小块数据
  * 浏览器下次访问服务器时，会自动携带该数据，将其发送给服务器
* Session
  * 是javaEE的标准，用于在服务端记录客户端信息
  * 数据存放在服务端更加安全，但是也会增加服务端的内存压力
### 4、生成验证码
* Kaptcha
  * 导入jar包
  * 编写Kaptcha配置类
  * 生成随机字符、生成图片
### 5、开发登录、退出功能
* 访问登陆页面
  * 点击顶部区域内的链接，打开登录页面
* 登录
  * 验证账号、密码、验证码
  * 成功时，生成登录凭证，发放给客户端
  * 失败时，跳转回登录页
* 退出
  * 将登录凭证修改为失效状态
  * 跳转至网站首页
### 6、显示登录信息
* 拦截器示例
  * 定义拦截器，实现HandlerInterceptor
  * 配置拦截器，为它指定拦截、排除的路径
* 拦截器应用
  * 在请求开始时查询登录用户
  * 在本次请求中持有用户数据
  * 在模板视图上显示用户数据
  * 在请求结束时清理用户数据
### 7、账号设置
* 上传文件
  * 请求：必须是post请求
  * 表单：enctype="multipart/form-data"
  * Spring MVC:通过MultipartFile处理上传文件
* 开发步骤
  * 访问账号设置页面
  * 上传头像
  * 获取头像
### 8、检查登录状态
* 使用拦截器
  * 在方法前标注自定义注解
  * 拦截所有请求，只处理带有该注解的方法
* 自定义注解
  * 常用的元注解<br>
  @Target,@Retention,@Document,@Inherited
  * 如何读取注解
  ```java
  Method.getDeclaredAnnotations()
  Method.getAnnotation(class<T> annotationClass)
  ```
  
