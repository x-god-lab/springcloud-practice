# 服务熔断和服务降级

* 服务熔断：服务端，某个服务超时或者异常，引起熔断，类似保险丝
  
* 服务降级：客户端，从整体网站负载进行考虑，当某个服务熔断或者关闭之后服务将不会被调用，
我们可以准备一个FallbackFactory,返回一个默认值（缺省值），
整体服务水平下降了~但是好歹能用