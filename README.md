# leyou

跨域:
    跨域场景: 协议不同,域名不同,端口不同,二级域名不同
    跨域前提: ajax 请求才会出现跨域
    解决方案: jsonp nginx cors
    cors: 服务端设置四个参数
    Access-Control-Allow-Origin: 
    Access-Control-Allow-Credentials: true
    Access-Control-Allow-Methods: GET, POST, PUT, ....
    Access-Control-Allow-Headers: X-Custome-Header
    实现: springMVC提供了CorsFilter过滤器,只要实现一下,就可以