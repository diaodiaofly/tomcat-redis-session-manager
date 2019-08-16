tomcat-redis-session-manager 
=======================================
---

tomcat版本
--------
tomcat8集群redis session共享解决方案
支持tomcat8.5，没有对tomcat8.0、tomcat7做测试


用法
---
添加下面的配置到tomcat的context.xml中【单机redis】

    <Valve className="com.seejoke.tomcat.redissessions.RedisSessionHandlerValve"/> 
	<Manager className="com.seejoke.tomcat.redissessions.RedisSessionManager" 
			  host="127.0.0.1"
			  port="6379"
			  database="0" 
			  password="123456"
			  maxInactiveInterval="1800" /> 

添加下面的配置到tomcat的context.xml中【集群redis】

    <Valve className="com.seejoke.tomcat.redissessions.RedisSessionHandlerValve" />                                                                                                            
    <Manager className="com.seejoke.tomcat.redissessions.RedisSessionManager"
            sentinelMaster="mymaster"
            sentinels="172.19.80.3:26379,172.19.80.4:26379,172.19.80.5:26379"
            database="2"
            password="123456"
           maxInactiveInterval="3600" />


复制下面的文件到TOMCAT_BASE/lib目录:

- tomcat-redis-session-manager.jar
- jedis-2.8.2.jar
- commons-pool2-2.2.jar

感谢
---
此版本修改自 https://github.com/jcoleman/tomcat-redis-session-manager