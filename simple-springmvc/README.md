# simple-springmvc
一个采用springMVC架构, 使用jetty插件部署的普通web服务.

## 作者
* Hinsteny [Home](https://github.com/Hinsteny)

### 项目介绍
项目本身采用Maven管理, jdk1.11, 配置基础的SpringMvc框架使用方法.

### 包含技术
*  Spring, Springmvc


### spring 中配置文件的相关解析

#### **context** 命名空间下(http://www.springframework.org/schema/context)的配置项统一由 _org.springframework.context.config.ContextNamespaceHandler_ 处理;

1) Xml中配置项的配置值替换植入处理器

```
  <context:property-placeholder location="classpath:app.properties" file-encoding="utf-8" ignore-unresolvable="true"/>
```
1. **property-placeholder** 由 _PropertyPlaceholderBeanDefinitionParser_ 处理, 如果配置项标签没有设置属性key='system-properties-mode'或者设置了, 并且value='ENVIRONMENT', 那就
初始化`PropertySourcesPlaceholderConfigurer`class的实例, 否则默认`PropertyPlaceholderConfigurer`class的实例;
2. 组装生成`PropertySourcesPlaceholderConfigurer`class的实例, 设置bean-id=`org.springframework.context.support.PropertySourcesPlaceholderConfigurer#{index}`, 如果配置多个此标签,
在spring启动解析项配置文件xml时, 便会定义多个此class的实例;
3. 


2) 配置进行包扫描的功能处理器

```
  <context:component-scan base-package="org.hisoka.controller" />
```
**component-scan** 由 _ComponentScanBeanDefinitionParser_ 处理, 对配置的包路径进行扫描, 注册所有扫描到的bean类;


#### **mvc** 命名空间下(http://www.springframework.org/schema/mvc)的配置项统一由 _org.springframework.web.servlet.config.MvcNamespaceHandler_ 处理;

#### **default-servlet-handler** 默认的servlet处理器

1) 配置启动默认的servlet处理器

```
  <mvc:default-servlet-handler/>
```

**default-servlet-handler** 由 _DefaultServletHandlerBeanDefinitionParser_ 处理

2) 配置静态资源访问处理器

```
  <mvc:resources mapping="/res/**" location="/WEB-INF/res/" />
```

**default-servlet-handler** 由 _ResourcesBeanDefinitionParser_ 处理

3) 针对web请求requestMapping的相关处理

```
  <mvc:annotation-driven />
```

**annotation-driven** 由 _AnnotationDrivenBeanDefinitionParser_ 处理, 生成`RequestMappingHandlerMapping`class的实例, 注册许多关于url映射, 数据转化, 异常捕获的处理器;