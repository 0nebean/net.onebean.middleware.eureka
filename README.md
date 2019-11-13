[![GitHub release](https://img.shields.io/badge/release-1.0.0-28a745.svg)](https://github.com/0nebean/com.alibaba.druid-0nebean.custom/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)


Introduction
---
- 对spring cloud服务发现中心 eureka的封装
- 通过脚本一键启动,可以后台运行在linux上
- 提供erueka集群配置参考
- 项目使用Apollo作为注册中心 ,以下是需要的配置namespace


Documentation
---
- config(以下是主从模式两台eureka的配置示例)

eureka-master

```
spring.application.name = net.onebean.middleware.eureka
server.port = 6101

eureka.instance.hostname = preeureka-master.eakay.cn
eureka.instance.lease-expiration-duration-in-seconds = 20
eureka.instance.lease-renewal-interval-in-seconds = 10
eureka.client.service-url.defaultZone = http://preeureka-slave.onebean.net:6102/eureka/
eureka.server.enable-self-preservation = false
eureka.server.eviction-interval-timer-in-ms = 10000
#logging
logging.level.root = info

```

eureka-server

```
spring.application.name = net.onebean.middleware.eureka
server.port = 6102

eureka.instance.hostname = preeureka-slave.eakay.cn
eureka.instance.lease-expiration-duration-in-seconds = 20
eureka.instance.lease-renewal-interval-in-seconds = 
eureka.client.service-url.defaultZone = http://preeureka-master.onebean.net:6101/eureka/
eureka.server.enable-self-preservation = false
eureka.server.eviction-interval-timer-in-ms = 10000
#logging
logging.level.root = info

```

- config(以下是单例eureka的配置示例)
```
spring.application.name = net.onebean.middleware.eureka
server.port = 8085
eureka.client.register-with-eureka = false
eureka.client.fetch-registry = false
eureka.client.serviceUrl.defaultZone = http://eureka.onebean.net:8085/eureka/
eureka.instance.lease-expiration-duration-in-seconds = 20
eureka.instance.lease-renewal-interval-in-seconds = 10
eureka.server.enable-self-preservation = false
eureka.server.eviction-interval-timer-in-ms = 10000

#logging
logging.level.root = info

```

Startup
---
- clean install -P${ENV}
- tar-zxvf ./server-fat-1.0.0-SNAPSHOT.tar.gz
- ./server/bin/startup.sh
- enjoy



