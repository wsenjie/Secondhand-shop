# 二手商城系统



## 一、数据库准备

​		1.Navicat for MySQL 版本：12.0.27

​		2.创建数据库shop

```mysql
CREATE DATABASE shop;
```

​		3.运行shop.sql文件



## 二、数据库表结构

- shop
  - car：购物车表
  - category：种类表
  - good：商品表
  - message：留言表
  - order：订单表
  - user：用户表



## 三、项目结构介绍

- java

  - com.example.shop

    - config：自定义配置类

    - controller：Controller层

    - dao：数据操作层DAO

    - entity：实体类

    - util：自定义工具类
    - Application：应用启动类
  - resource
      - mapper：mapper映射文件
      - public：图片文件上传（存储静态文件）
      - templates：动态页面
      - application.yml：应用配置文件，应用启动自动读取配置
      - 



## 四、更改数据配置

​		打开application.yml文件，修改相应的数据源配置，比如账号、密码等。(如果server.port端口8000冲突，则修改端口号)。



## 五、Mybatis相关配置

```yaml
mybatis:  
  mapper-locations: classpath:mapper/*.xml  # mapper文件地址
  configuration:
#    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl    
  map-underscore-to-camel-case: true
```

**在 Application 应用启动类添加注解 @MapperScan**

Application.java 代码如下：

```java
/**
 * Spring Boot 应用程序启动类
 * @author sen
 */
 
// mapper 接口类扫描包配置
@MapperScan("com.example.shop.dao")
//@ComponentScan({"com.example.shop","com.example.shop.util"})、
// Spring Boot 应用的标识
@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }
}
```



## 六、项目运行

首页：http://localhost:8000/


































