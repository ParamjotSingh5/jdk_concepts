import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

// Target class (no interface)
class TaskService {
    public void execute() {
        System.out.println("Executing task in TaskService");
    }
}

// CGLIB Method Interceptor
class CustomMethodInterceptor implements MethodInterceptor {
    private final Object target;

    public CustomMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
}

public class CglibProxyExample {
    public static void main(String[] args) {
        TaskService target = new TaskService();

        TaskService proxy = (TaskService) Enhancer.create(
                TaskService.class,
                new CustomMethodInterceptor(target)
        );

        proxy.execute();
    }
}