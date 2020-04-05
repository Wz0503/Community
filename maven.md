# maven常用命令

## 1、creating new project
--------------------------------
    mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app 
    -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
    
    DgroupId一般为域名
    DartifactId为项目名
    
## 2、compile
---------------
    mvn compile
    
## 3、清理
---------------
    mvn clean
    
## 4、清理并编译
    mvn clean compile
    
## 5、测试
    mvn clean test
    
 一般情况下，使用集成开发环境idea等更方便创建maven工程<br/>
 [maven使用指南](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
    
