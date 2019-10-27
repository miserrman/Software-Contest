# Software-Contest

## 10月25日后端记录
1. mybatis文件的发现与配置问题\
    (1)首先要在application里面写上关于xml文件的配置，让springboot系统可以发现xml文件\
    ```
    mybatis.mapperLocations=classpath:mappers/*.xml
    ```
    (2)xml映射文件要根据application.properties填写的路径存储在resource文件夹里.\
    (3)建立dao层和model层，网上说如果要把dao看作一个bean的话就使用@Repository,数据库即调用成功，尚不清楚如果单纯把它看作映射怎么使用(@Mapper)
2. 测试类无法注入的问题\
   顺序要正确
   ```
    @RunWith(SpringRunner.class)
    @SpringBootTest(classes=DapeiApplication.class)
   ```
### 10月27日后端记录
#### 数据库需要修改内容
1. 所用ID字段改为自增
2. clothes字段除ID其他字段不需要NOT NULL