1. 启动oracle

   ```
   # 本环境使用了sath89/oracle-xe-11g的image
   docker run -d -p 8080:8080 -p 1521:1521 sath89/oracle-xe-11g
   ```





Error:(16, 0) Cannot convert the provided notation to an object of type Dependency: /Users/wjlin/works/coach/153-spring-mybatis-oracle/mybatis-oracle/libs/ojdbc7.jar.
The following types/formats are supported:
  - Instances of Dependency.
  - String or CharSequence values, for example 'org.gradle:gradle-core:1.0'.
  - Maps, for example [group: 'org.gradle', name: 'gradle-core', version: '1.0'].
  - FileCollections, for example files('some.jar', 'someOther.jar').
  - Projects, for example project(':some:project:path').
  - ClassPathNotation, for example gradleApi().

Comprehensive documentation on dependency notations is available in DSL reference for DependencyHandler type.
<a href="openFile:/Users/wjlin/works/coach/153-spring-mybatis-oracle/mybatis-oracle/build.gradle">Open File</a>