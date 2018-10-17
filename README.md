# 616321PAGE
成航616321班网站

## 项目结构

  
    └─src
        └─main
            ├─java
            │  └─cap
            │      ├─interceptor
            │      ├─mvc
            │      │  ├─bean
            │      │  ├─controller
            │      │  │  └─resource（提供资源的controller，这里是提供图片（所有需要的动态上传的图片）)
            │      │  ├─dao
            │      │  │  └─mapper
            │      │  │      └─custom
            │      │  ├─model
            │      │  │  ├─association（自定义model）
            │      │  │  ├─ex （扩展model）
            │      │  │  └─wrapper （对wrapper进行包装，比如本身Event中存的日期为一个Long我要将Long转为Date就用EventWapper中的getFormatDt)
            │      │  └─service
            │      └─util
            ├─resources
            │  └─mapper
            │      └─custom
            ├─test
            │  └─junit
            └─webapp
                ├─css
                ├─editor.md
                ├─error
                ├─image
                ├─js
                └─WEB-INF
                    └─jsp
                        ├─authority
                        │  └─1
                        ├─colloection
                        ├─pagemodel
                        └─__framework
                        
                        
                        

使用mybatis-generator生成的dao(mapper)只有单表的增删改查，但是我们需要根据自己的业务逻辑添加不同的sql。
这里我们把我们自定义的mapper单独提出来，避免和生成的代码混淆，以便以后对数据库作修改， 如项目结构所示（其本有个注意点就是生成的mapper类为什么要继承于custom中mapper类）

