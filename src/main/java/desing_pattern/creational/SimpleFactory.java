package desing_pattern.creational;

import lombok.extern.slf4j.Slf4j;

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
    private static class Vehicle {

    }
    /**
     * 产品类
     */
    private static class Car extends Vehicle {
        public Car() {
            System.out.println("生产小汽车");
        }
    }
    private static class Bus extends Vehicle {
        public Bus() {
            System.out.println("生产公交车");
        }
    }
    private static class Motorbike extends Vehicle {
        public Motorbike() {
            System.out.println("生产摩托车");
        }
    }

    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle car = factory.getVehicle(1);
        Vehicle bus = factory.getVehicle(2);
        Vehicle motorbike = factory.getVehicle(3);
    }
}
