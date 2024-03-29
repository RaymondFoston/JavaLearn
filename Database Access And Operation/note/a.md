#####自动映射
- 全局setting设置
    - autoMappingBehavior默认是PARTIAL，开启自动映射的功能，要求列名与javabean属性名一致；如果为null，取消自动映射的功能
    - mapUnderscoreToCamelCase，开启驼峰映射功能a_col会映射为aCol
- 自定义map，实现高级结果映射集