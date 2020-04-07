# Spring and Mybatis study
springboot核心作用：起步依赖，自动配置，端点监控

## 1、spring
spring全家桶
* spring framework
* spring boot
* spring cloud
* spring cloud data flow

spring core:<br/>
* Ioc: 控制反转，是一种面向对象编程的设计思想<br>
依赖注入，是Ioc思想的实现方式<br>
Ioc容器，是实现依赖注入的关键，本质上是一个工厂

![](https://github.com/Wz0503/Community/raw/master/images/container-magic.png)  
bean在spring容器中只实例化一次，只销毁一次，为单例模式<br>



## 2、Spring MVC

* HTTP
* Model(模型层)、View(视图层)、Controller(控制层)<br>
核心组件：DispatcherServlet<br>
所有的组件都有DispacherServlet去调度，DispacherServlet会调controller的某个方法，这个方法给它返回model数据，也需要给它返回视图相关数据<br>
然后它把model和view都提交给模板引擎，由模板引擎进行渲染，生成动态html。


![](https://github.com/Wz0503/Community/raw/master/images/mvc.png)


## 3、Thymeleaf
模板引擎，生成动态的html，倡导自然模板，即以html文件为模板；标准表达式、判断与循环、模板的布局。<br>
异步请求：页面未刷新，但是也访问了服务器得到了一个结果。（多用于json数据）


## 4、Mybatis
* 核心组件
  * SqlSessionFactory：用于创建SqlSession的工厂类
  * SqlSession：MyBatis的核心组件，用于向数据库执行SQL;
  * 主配置文件：XML配置文件，可以对MyBatis的底层行为做出详细的配置
  * Mapper接口：就是DAO接口，在MyBatis中习惯性称之为Mapper;
  * Mapper映射器：用于编写sql,并将sql和实体类映射的组件，采用XML、注解均可实现。


