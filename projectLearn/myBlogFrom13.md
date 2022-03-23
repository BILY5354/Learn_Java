## 1在linux上安装mysql

```
1. 通过secureCRT工具连接Linux系统

2. 上传 mysql 的安装包

    alt + p -------> put d:/setup/mysql-5.7.27-1.el7.x86_64.rpm-bundle.tar

3. 解压 mysql 的安装包

	mkdir mysql
    
	tar -xvf mysql-5.7.27-1.el7.x86_64.rpm-bundle.tar -C mysql/


4. 安装客户端
    
	cd mysql/
    
	rpm -ivh mysql-community-client-5.7.27-1.el7.x86_64.rpm --force --nodeps


5. 安装服务端
    
	rpm -ivh mysql-community-server-5.7.27-1.el7.x86_64.rpm --force --nodeps


6. 修改mysql默认字符集
    
	vi /etc/my.cnf
    
	添加如下内容：
    
	[mysqld]
	character-set-server=utf8
	collation-server=utf8_general_ci
 
	-- 在文件最下方添加
    
	[client]
	default-character-set=utf8

7. 启动mysql服务
    
	service mysqld start

8. 登录mysql
    
	mysql -u root -p  敲回车，输入密码
    
	初始密码查看：cat /var/log/mysqld.log
    
	在root@localhost:   后面的就是初始密码

9. 修改mysql登录密码
    
	set global validate_password_policy=0;
    
	set global validate_password_length=1;
    
	set password=password('密码');
	
	//mysql 8.0设置（需先设置一个满足要求的密码）
	set global validate_password.policy=0;

	set global validate_password.length=1;
	
	 ALTER USER ‘root‘@‘localhost‘ IDENTIFIED BY ‘你的密码‘;


10. 授予远程连接权限 
    
	//授权 root80一定要对应刚刚的密码
	grant all privileges on *.* to 'root' @'%' identified by 'root80';
    
	//8.0之后，只能先创建账号，再授权

	create user test@'%' identified by 'root80';

	GRANT  all privileges  ON *.* TO test@'%';
	
	//刷新
	flush privileges;


11. 关闭Linux系统防火墙
	systemctl stop firewalld

12. 重启mysql服务
	service mysqld restart

13. 使用SQLYog工具连接mysql

//看端口
show variables like 'port';
//修改端口需要
setenforce 0
//重启
service mysqld restart
```



## 线上

```sh
wget https://labfile.oss.aliyuncs.com/courses/1367/lou-springboot.zip
unzip lou-springboot.zip

//运行项目
cd lou-springboot
mvn spring-boot:run
```



项目初始化时我们选择的打包方式为 Jar ，因此项目开发完成进行打包时的结果是一个 Jar 包， Java 运行 Jar 包的命令为 `java -jar xxx.jar` ，结合以上两个原因我们可以使用这种方式启动 Spring Boot 项目，接下来我们来演示这一过程。

- 首先，点击下方工具栏中的 Terminal 打开命令行窗口
- 之后使用 Maven 命令将项目打包，执行命令为:`mvn clean package -Dmaven.test.skip=true`，等待打包结果即可
- 打包成功后进入 target 目录，`cd target`
- 最后就是启动已经生成的 Jar 包，执行命令为`java -jar springboot-demo-0.0.1-SNAPSHOT.jar`

这种方式也是 Spring Boot 上线时常用的启动流程，希望不熟悉的朋友都按照以上过程练习几次。