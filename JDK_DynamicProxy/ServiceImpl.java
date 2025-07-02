package dynamicproxy;

public class ServiceImpl implements Service  {
    @Override
    public void performTask() {
        System.out.println("Executing task in ServiceImpl");
    }

    @Override
    public void performAnotherTask(String taskName) {
        System.out.println("Executing another task: " + taskName + " in ServiceImpl");
    }
}
