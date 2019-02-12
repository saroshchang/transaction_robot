## framework spring-boot+mybatis+freemarker
	MongoDb、Readis NoSQL
##運行

  $ mvn spring-boot:run


## 目錄說明

 ------- src/main/java
 -------------|-----------com.etchain由於反序列化，必須用com.etchain..等package，才能在Readis上為交易所使用
 -------------|-----------controller #控制層
 -------------|-----------dao        #DAO接口
 -------------|-----------po         #實體類
 -------------|-----------service    #Service接口和實現類
 -------------|-----------config	 #配置跨域請求、資料庫初始化、swagger-ui
 -------------|-----------Run.java   #入口
 ----------resources
 -------------|-----------o.g.d.d.mybatis  #mybatis mapper配置文件
 -------------|----------templates   # freemarker 模板文件
 -------------|----------application.yml #配置文件
 -------------|----------logback.xml  #loback日誌配置文件
 -------------|----------mybatis-config.xml   #mybatis基礎配置文件




