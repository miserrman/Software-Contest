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

### 10月30日后端记录
1. 加入收藏的功能，收藏指的是在穿搭界面点喜欢, 建立收藏表
2. 什么衣服添加进了衣柜这个表没有.

### 11月7日
1. 项目题目
2. 市场痛点和特色
3. 完成目标（实现功能）
4. 进度计划（已完成计划和已有资源）

背景： 随着生活水平的提高，每个人拥有的衣服数量越来越多，增加了衣物管理的困难
#### 市场痛点


1. 市场调研和可行性分析,资料查找，深度学习数据集收集。前端UI设计，后端架构设计，数据库设计。
2. 后端架构搭建,前端页面结构与架构搭建,分析算法实现步骤。
3. 实现大部分算法，填充后端各个模块的功能，实现前端的视觉效果和页面逻辑。实现前后端的数据交互。
4. 对快应用进行落地测试，增加应用代码的健壮性，对已有算法进行优化和测试。优化前端界面的使用体验

### 11月21日
1.后端还缺了两张表，关于义务和穿搭关系的表
2.收藏需要两个函数，一个查询它是否被收藏，一个是点击，如果已经收藏，则取消收藏，如果没有收藏，进行收藏。

1. 用户可互相 分享喜欢的搭配
2. 亲密好友可以实现衣柜互联，互相查看对方衣柜的衣物。
3. 商家注册账户，也可以在平台上推销自己的服装产品，供用户浏览。

### 11月27日
中期后端目标：
1. 项目部署在docker centeos上，并可以正常运行
2. 可以完成简单的用户信息的录入，自动登录等操作。
3. 登陆后获取用户的信息和身形的信息（返回复合类），可以修改用户身形的信息
4. 衣柜功能完善：添加衣服，删除衣服，获取衣服具体信息。
5. 识别衣服可以存储用户的衣服图片，并能正确的处理图片
6. 识别完后可以返回正确的衣服信息，前后端url需要一致
7. 产生穿搭，可以调用python文件进行处理,后端可以找到图片进行处理