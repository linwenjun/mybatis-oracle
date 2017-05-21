## mybatis + flyway + orcale demo

### 系统需求


1. JDK 1.8
2. oracle(运行demo推荐使用docker)

     ```
     # 作者使用了sath89/oracle-xe-11g的image
     docker run -d -p 8888:8080 -p 1521:1521 sath89/oracle-xe-11g
     ```
3. IDE 推荐使用intellij idea

     ​


### 配置方法
1. 配置flyway数据库参数，修改 **src/main/resources/mybatis-config.xml** 其中的xe指SID

   ```xml
   # 
   <property name="url" value="jdbc:oracle:thin:@127.0.0.1:1521:xe"/>
   <property name="username" value="test"/>
   <property name="password" value="123456"/>
   ```



2. 配置mybatis数据库参数，修改 **gradle.properties**

   ```properties
   flyway.url=jdbc:oracle:thin:@127.0.0.1:1521:xe
   flyway.user=test
   flyway.password=123456
   ```

   ​

### 运行

1. 初始化数据表

```
./graldew flywaymigrate
```

2. 直接运行 App 类主方法
3. 打开浏览器，输入 http://localhost:8080/blogs

```
./gradlew bootrun
```

