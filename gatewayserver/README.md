### Spring Cloud Zuul:
Zuul is an edge service that allows us to route incoming HTTP requests into multiple backend microservices. For one thing, this is important for providing a unified API for consumers of our backend resources.
Basically, Zuul allows us to unify all of our services by sitting in front of them and acting as a proxy. It receives all requests and routes them to the correct service. To an external application, our API appears as a unified API surface area.

further references:     
- https://www.baeldung.com/spring-security-zuul-oauth-jwt
- https://spring.io/guides/gs/routing-and-filtering/

### Project Descriptions:
please see application.properties files in resources folder. you can check test methods too.  
steps:
-   first run discoveryserver and configserver and run this server to test get configuration from configserver visit this link in browser: http://localhost:8080/message
-   second run GrpcStarterServer and then GrpcStarterClient project and test routing by visiting these links in browser: http://localhost:8080/server/message and http://localhost:8080/client/message

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