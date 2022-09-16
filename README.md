# 工程简介
本来想使用COLA4.0作为工程的基本结构，但考虑到业务场景梳理的难度、开发人员开发的上手难度，还是决定采用比较常见的三层架构。系统中的bean以pojo为主，少数bean可以定义其自身特有的方法。

###工程各个模块的说明如下：
1. backend-api：用于存放dto，定义service层接口，初始工程的dto基于cola4.0的基础包进行改造。对于service的接口，在名字末尾加I，以方便阅读（例如, 接口UserServiceI
和 实现UserServiceImpl）。为了维护代码的可读性，在此对Command和Query进行说明，Query用于单纯的查询，Command用于数据的修改（其中可以操作Query）。

2. backend-common： 通用包，用于引入第三方工具包（pom文件管理），定义工具类（位于utils目录下），定义通用bean（如异常、系统层面的DTO或POJO等）

3. backend-dao： 持久层，用于操作资源，例如数据库、oss等。工程使用mybatis-plus操作数据库，可以参考[相关文档](https://baomidou.com/pages/226c21/)。

4. backend-service： 业务逻辑层，主要放置接口实现类，一些切面功能。对于不同功能模块，可以在service目录下新建目录进行编码。（如user目录对应用户模块的service）。catchlog
目录存放日志捕捉的工具，在方法上添加`@CatchAndLog`注解即可。
4. backend-web：用户接入层，可以存放controller、websocket等。response目录存放全局响应处理等文件。
5. start：工程启动、环境配置等

### 各模块依赖关系 
* backend-api : 无 
* backend-common ： 无
* backend-dao ： backend-common 
* backend-service ： backend-api,backend-dao
* backend-web ： backend-api,backend-service
* start：backend-web 




#### 注意：
开发过程中，对于操作数据库的操作，需要编写对应的单元测试用例，方便后来开发人员的快速上手

## 项目启动
1. 安装maven，配置本地仓库，拉取相关依赖
2. 启动 BackendApplication

# 延伸阅读
1. [mybatis-plus文档]( https://baomidou.com/pages/226c21/)
2. 