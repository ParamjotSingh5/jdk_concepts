package dynamicproxy;

import java.lang.reflect.Proxy;

public class JdkDynamicProxyExample {

    public static void main(String[] args) {
        Service target = new ServiceImpl();
        Service proxiedService = (Service) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{Service.class},
                new CustomInvocationHandler(target)
        );

        proxiedService.performTask();
        proxiedService.performAnotherTask("Sample Task");
    }
}
