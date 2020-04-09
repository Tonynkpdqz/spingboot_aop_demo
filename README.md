# spingboot_aop_demo
使用了springAOP，filter，拦截器的一个demo，完整展现了他们的拦截顺序。
附带一个小demo，用于验证用户是否登陆（携带token）
记录：filter的使用方法：实现Filter接口，使用@WebFilter注解，在主类上使用@@ServletComponentScan注解
拦截器使用方法：实现HandlerInterceptor接口或者继承HandlerInterceptorAdapter类，重写方法，然后在实现了WebMvcConfigurer接口的类上
使用addInterceptors方法注册拦截器，指定拦截路径和不拦截路径即可。
AOP：在切面类上加这两个注解@Component，@Aspect，指定一个@pointcut（表达式）方法作为切点，然后就可以针对这个切点
使用@Before，@After，@Around，@AfterReturning增强方法了。
