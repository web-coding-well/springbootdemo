# springbootdemo
a spring boot demo project


## Environment
* IntelliJ IDEA 2016
* Windows 10
* JDK 1.8
* SpringBoot 1.5.2
* Maven 3.3.9
* Mysql 5.7.16

---
## 阿里云镜像
* 修改maven根目录下的conf文件夹中的setting.xml
```
<mirrors>
    <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
    </mirror>
  </mirrors>
```
* 如果是IDEA自身的Maven,则右键工程-->Maven-->Create "settings.xml",在里面添加上上述镜像，然后体验如飞的速度

---
## 打包jar发布

* 进入工程主目录
* cmd:mvn package -Dmaven.test.skip=true
* 在target中找到生成的****.jar
* 运行：cmd:java -jar ****.jar

---
## 配置文件
* application.properties跟打包好的jar包放在同一目录即可使外部的application.properties生效
* 或者在当前目录的 “/config”的子目录下
* 当前目录是指****.jar包的目录下,config目录下的application.properties优先级较高
* 如果只是想更改端口号，则可以通过命令行（优先级最高）
* cmd:java -Dserver.port=8089 -jar ****.jar

---
## 解决端口被占用

* 找到端口占用的pid(最后一个)
* cmd:netstat -ano|findstr "8089"
* 根据pid查看进程（比如查到是Tencentdl.exe）
* cmd:tasklist|findstr  "2656"
* 强制杀死进程id
* cmd:taskkill /F /pid 2656
* 或者根据查出的进程强制杀死进程
* taskkill /f /t /im Tencentdl.exe

---
## 日志

* 指定日志文件
* logging.file=./springboot.log
* 指定日志级别
* logging.level=info
* 代码使用日志
* Logger logger =  LoggerFactory.getLogger(this.getClass());
---
## 实现热部署（不完全）
* pom.xml中添加
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<optional>true</optional>
</dependency>
```
```
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
	<configuration>
		<fork>true</fork>
	</configuration>
</plugin>
```
* 快捷键Ctrl+F9，build project后刷新即可看到代码改动后的样子

---
## 添加Thymeleaf或FreeMarker支持
* 两者可以共存，只是Thymeleaf后缀为html,浏览器可以直接渲染，而FreeMarker后缀为ftl
* 官方推荐使用Thymeleaf

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```
---
## IDEA REST Client
* 模拟客户端请求时可用IDEA自带的rest client
* 按下Ctrl+Shift+a,输入rest client即可找到入口
