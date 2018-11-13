SpringBoot+Mybatis+MySQL+Swagger演示项目
=====
## greek项目简介
- greek项目是Java语言的系统架构，为了使采用Spring整合各种开源框架，进而提升自身技能，同时验证各类技术的性能，做好技术选型工作。
- 使用Maven对项目进行模块化管理，提高项目的易开发性、扩展性。
- 使用分布式版本管理工具Git，对项目的源码进行管理，体验Git版本管理的优势，重点区分工作区、暂存区、本地库以及远程库等概念。
## 主要功能
 1. 数据库：Druid数据库连接池，监控数据库访问性能，统计SQL的执行性能。 数据库密码加密，加密方式请查看PropertiesUtil，decryptProperties属性配置需要解密的key。
 2. 持久层：mybatis持久化，使用MyBatis-Plus优化，减少sql开发量。
 3. Swagger：是一个规范和完整的框架，用于生成、描述、调用和可视化RESTful 风格的 Web 服务。具有接口的文档在线自动生成和功能测试的功能。
 4. 缓存和Session：注解redis缓存数据；spring session集成redis实现分布式session管理。
 5. MySQL数据库，利用MySQL数据库完成数据的持久化存储，使用SQL语句优化、索引优化、表结构优化来提高数据检索的效率。
 6. 工具类：excel导入导出，汉字转拼音，身份证号码验证，数字转大写人民币，FTP/SFTP/fastDFS上传下载，发送邮件，redis缓存，加密等等。

## 技术选型
    ● 核心框架：Sring boot + Spring Framework
    ● 安全框架：Apache Shiro
    ● 持久层框架：MyBatis + MyBatis-Plus
    ● 数据库：MySQL5.5
    ● 数据库连接池：Alibaba Druid
    ● 缓存框架：Redis
    ● 接口在线预览框架：Swagger
    ● 会话管理：Spring-Session
    ● 日志管理：SLF4J、Log4j2
    ● 前端框架：微信小程序

## 核心知识点汇总
### 1.Swagger是一组开源项目，是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。总体目标是使客户端和文件系统作为服务器以同样的速度来更新。文件的方法，参数和模型紧密集成到服务器端的代码，允许API来始终保持同步。其中主要要项目如下：
- Swagger-tools:提供各种与Swagger进行集成和交互的工具。例如模式检验、Swagger 1.2文档转换成Swagger 2.0文档等功能。
- Swagger-core: 用于Java/Scala的的Swagger实现。与JAX-RS(Jersey、Resteasy、CXF...)、Servlets和Play框架进行集成。
- Swagger-js: 用于JavaScript的Swagger实现。
- Swagger-node-express: Swagger模块，用于node.js的Express web应用框架。
- Swagger-ui：一个无依赖的HTML、JS和CSS集合，可以为Swagger兼容API动态生成优雅文档。
- Swagger-codegen：一个模板驱动引擎，通过分析用户Swagger资源声明以各种语言生成客户端代码。