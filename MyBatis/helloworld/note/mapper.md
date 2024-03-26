- 单个参数：
mybatis不做特殊处理，#{任意参数名}即可取出参数值
- 多个参数值:
mybatis会做特殊处理
多个参数会被封装成 一个map：{key:value} 
[arg1, arg0, param1, param2]
{arg0: param1;
 arg1: param2
}
特别注意，如果是Collection(List,Set)类型或者是数组，key的命名不是arg，
Collection会被命名为collection,List会被命名为list,数组会被命名为array
取值时按key取值#{arg0},或者按value取值#{param1}
- 命名参数：明确指定封装参数时map的key
在mapper中使用注解@Param(arg)
key: 注解指定的值
value： 参数值
[lastName, id, param1, param2]
- POJO
如果多个参数是业务逻辑的数据模型，可以直接传入pojo
这时，使用#{属性名}直接取出参数值
- Map
如果多个参数不是业务逻辑的数据模型，不经常使用可以通过传入map
使用#{key}取出map中对应的参数值
- TO: Transfer Object
如果多个参数不是业务逻辑的数据模型，经常使用，编写一个TO对象
- 参数值的 获取
\#{}; ${}
两者都可以获取map中的值和pojo属性的值
区别：
    \#{}： 以预编译的方式将参数设置到sql语句 中
    ￥{}： 取出的值直接拼接到sql语句上
大部分时候,都使用\#{}
在原生jdbc不支持占位符的地方，可以考虑使用${}.比如分表查询，排序
```sql
select * from ${year}_salary
select * from  employee order by  ${f_name} ${order}
```
- \#{}其他用法
规定参数的一些规则：
javaType,jdbcType,mode(存储过程), numericScale
resultMap, typeHander , jdbTypeName, expression
jdbdType需要在某些特定的条件下被设置：
    - 在我们数据为null的时候，某些数据库不能识别mybatis对null的默认处理，比如Oracle.
       因为mybatis对所有的null映射的都是j'dbc的other类型，
    - 在全局配置中，jdbcTypeForNull = other,oracle不支持，有如下两种解决办法：
        - 在映射文件中的sql语句，参数引用时，使用\#{email，jdbcType=NULL}
        - 在全局配置文件中，设置jdbcTypeForNull = null