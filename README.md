# springbootdemo
a spring boot demo project


## Environment
* IntelliJ IDEA 2016
* Windows 10
* JDK 1.8
* SpringBoot 1.5.2

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
