# springbootdemo
a spring boot demo project


## Environment
* IntelliJ IDEA 2016
* Windows 10
* JDK 1.8
* SpringBoot 1.5.2
* Maven 3.3.9

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
* cmd:mvn package -Dmavne.test.skip=true
* 在target中找到生成的****.jar
* cmd:java -jar ****.jar

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
