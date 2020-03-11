package desing_pattern.creational;

import java.lang.management.MonitorInfo;

/**
 * 简单工厂
 * 1. 根据不同的类型生成不同类型的实例
 * @author zhangqisheng
 */
public class SimpleFactory {
    /**
     * 工厂类
     */
    private static class VehicleFactory {

        public Vehicle getVehicle(int type) {
            switch (type) {
                case 1:
                    return new Car();
                case 2:
                    return new Bus();
                case 3:
                    return new Motorbike();
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
    /*
     *
     */
    private interface Vehicle {

    }
    /**
     * 产品类
     */
    private static class Car implements Vehicle {

    }
    private static class Bus implements Vehicle {

    }
    private static class Motorbike implements Vehicle {

    }
}
