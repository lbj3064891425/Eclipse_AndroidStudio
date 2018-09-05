# Eclipse_AndroidStudio
使用eclipse搭建后台实现安卓的登录注册

Eclipse的Web项目在文件夹z_EclipseCode_Web下：

![1](https://github.com/JinxLori/BlogImage/raw/master/Eclipse_AndroidStudio/1.png)

导入连接数据库的jar包以及其他必须的jar包来配置自己的连接数据库类：

![2](https://github.com/JinxLori/BlogImage/raw/master/Eclipse_AndroidStudio/2.png)

```java
String url = "jdbc:mysql://localhost:3306/etc";//ETC为自己的数据库名
			// 5.获取mysql连接账号
			String mysql_name = "root";//用户名
			String mysql_password = "111111";//数据库密码
```

![3](https://github.com/JinxLori/BlogImage/raw/master/Eclipse_AndroidStudio/3.png)



修改LoginActivity以及RegisterActivity中的访问地址：

![4](https://github.com/JinxLori/BlogImage/raw/master/Eclipse_AndroidStudio/4.png)

```java
String path = "http://192.168.1.4:8080/ForAndroid/loginServlet?name=" + name + "&password=" + password;
```

192.168.1.4为自己本机ip而不是localhost，本机ip可通过cmd命令查询，



