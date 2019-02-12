## framework spring-boot+mybatis+freemarker
	MongoDb、Redis NoSQL
##運行

  $ mvn spring-boot:run


## 目錄說明

 --- src/main/java
 ----------------com.etchain#因
 ----------------controller #控制層
 ----------------dao        #DAO接口
 ----------------po         #實體類
 ----------------service    #Service接口和實現類
 ----------------config	 #配置跨域請求、資料庫初始化、swagger-ui
 ----------------Run.java   #入口
 ---- resources
 ----------------o.g.d.d.mybatis  #mybatis mapper配置文件
 ----------------templates   # freemarker 模板文件
 ----------------application.yml #配置文件
 ----------------logback.xml  #loback日誌配置文件
 ----------------mybatis-config.xml   #mybatis基礎配置文件




