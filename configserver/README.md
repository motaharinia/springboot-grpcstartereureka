## Spring Cloud Config Server:
Spring Cloud Config Serve provides server and client-side support for externalized configuration in a distributed system. With the Config Server you have a central place to manage external properties for applications across all environments

### Config Server Security:
The Spring Cloud Config Server (lets say SCCS from here onwards) support basic authentication out of the box

further references:     
- https://dzone.com/articles/microservices-and-spring-cloud-config-server
- https://spring.io/guides/gs/centralized-configuration/
- https://medium.com/@susindaperera/securing-spring-cloud-config-server-eac7b46f3e41

### Project Descriptions:
We have an application.properties in "/resources" and we can have multiple properties files for any microservice in "/resources/configserverrepo/{MICROSERVICE:spring.application.name}-{MICROSERVICE:spring.profiles.active}.properties"
For example we can get the "GrpcStarterServer" microservice "dev" config in browser with: "http://localhost:8762/config/GrpcStarterServer/dev" with "motahariniaconfig" and "123456" login information.
i set the other microservice application-dev.properties files in the resource folder for test. but we can config it to read them from github repository.

### IntellliJ IDEA Configurations:
- IntelijIDEA: Help -> Edit Custom Vm Options -> add these two line:
    - -Dfile.encoding=UTF-8
    - -Dconsole.encoding=UTF-8
- IntelijIDEA: File -> Settings -> Editor -> File Encodings-> Project Encoding: form "System default" to UTF-8. May be it affected somehow.
- IntelijIDEA: File -> Settings -> Editor -> General -> Code Completion -> check "show the documentation popup in 500 ms"
- IntelijIDEA: File -> Settings -> Editor -> General -> Auto Import -> check "Optimize imports on the fly (for current project)"
- IntelijIDEA: File -> Settings -> Editor -> Color Scheme -> Color Scheme Font -> Scheme: Default -> uncheck "Show only monospaced fonts" and set font to "Tahoma"
- IntelijIDEA: Run -> Edit Configuration -> Spring Boot -> XXXApplication -> Configuration -> Environment -> VM Options: -Dspring.profiles.active=dev
- IntelijIDEA: Run -> Edit Configuration -> Spring Boot -> XXXApplication -> Code Coverage -> Fix the package in include box

<hr/>
<a href="mailto:eng.motahari@gmail.com?"><img src="https://img.shields.io/badge/gmail-%23DD0031.svg?&style=for-the-badge&logo=gmail&logoColor=white"/></a>