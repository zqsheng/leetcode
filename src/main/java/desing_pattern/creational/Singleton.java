package desing_pattern.creational;

public class Singleton {

    static class SingletonObject1 {

    }

    static final SingletonObject1 instance = new SingletonObject1();

    public SingletonObject1 getInstance1() {
        return instance;
    }

    static class SingletonObject2 {

    }

    static SingletonObject2 instance2;
    public static synchronized SingletonObject2 getInstance2() {
        if(instance2 == null) {
            new SingletonObject2();
        }
        return instance2;
    }
}
