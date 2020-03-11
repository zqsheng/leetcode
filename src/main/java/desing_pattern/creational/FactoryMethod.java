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
            return null;
        }
    }


    private class Vehicle {

    }

    private class Car extends Vehicle {

    }
    private class Bus extends Vehicle {

    }
    private class MontorBike extends Vehicle {

    }
}
