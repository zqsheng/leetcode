package desing_pattern.creational;

/**
 * 工厂方法
 * @author zhangqisheng
 */
public class FactoryMethod {

    private interface VehicleFactory {

        Vehicle product();
    }

    private static class BusFactory implements VehicleFactory {

        @Override
        public Vehicle product() {
            return new Bus();
        }
    }

    private static class CarFactory implements VehicleFactory {
        @Override
        public Vehicle product() {
            return new Car();
        }
    }

    private static class MotorbikeFactory implements VehicleFactory {
        @Override
        public Vehicle product() {
            return new MotorBike();
        }
    }

    private static class Vehicle {

    }

    private static class Car extends Vehicle {
        public Car() {
            System.out.println("小汽车");
        }
    }
    private static class Bus extends Vehicle {
        public Bus() {
            System.out.println("公交车");
        }
    }
    private static class MotorBike extends Vehicle {
        public MotorBike() {
            System.out.println("摩托车");
        }
    }

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        BusFactory busFactory = new BusFactory();
        MotorbikeFactory motorbikeFactory = new MotorbikeFactory();
        Vehicle car = carFactory.product();
        Vehicle bus = busFactory.product();
        Vehicle motorbike = motorbikeFactory.product();



    }
}
