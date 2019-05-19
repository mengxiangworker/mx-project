# 工程目录说明
- controller包： 存放对外接口，url前缀统一加功能模块标识。内部不能添加任何业务逻辑。
- service包：业务逻辑包，主要业务逻辑。最好业务逻辑先定义接口。
- repository：数据通讯层，集mybatis接口定义的地方。
- entity：实体层，与数据层对应对象定义的地方。
- model：业务逻辑层对象定义的地方。
- dto：对外输出的对象定义的地方，即接口返回必须是dto对象。可继承自model。
- util：工具类存放的地方。
- config：系统配置存放的地方。
- context：spring配置类文件。
- exception：异常声明类文件。

- mapper： mybatis的mapper配置文件存放地方。
- sql：实体表创建sql。
