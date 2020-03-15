package desing_pattern.creational;

import java.util.Hashtable;
import java.util.Map;

/**
 * 原型模式(prototype):是用于创建重复的对象，同时又能保证性能。它提供了一种创建对象的最佳的方式。
 * 1.意图：用原型的实例指定创建对象的类型，并且通过拷贝这些原型创新新的对象。
 * 2.主要解决运行期建立和删除原型
 *
 * @author zhangqisheng
 */
public class Prototype {

    static abstract class Shape implements Cloneable {
        private String id;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public abstract void draw();

        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    static class Rectangle extends Shape {

        public Rectangle() {
            super.type = "rectangle";
        }

        @Override
        public void draw() {
            System.out.println("Inside Rectangle::drwa() method");
        }
    }
    static class Square extends Shape {

        public Square() {
            super.type = "squre";
        }

        @Override
        public void draw() {
            System.out.println("Inside Square::drwa() method");
        }
    }
    static class Circle extends Shape {
        public Circle() {
            super.type = "circle";
        }

        @Override
        public void draw() {
            System.out.println("Inside circle::drwa() method");
        }
    }

    static class ShapeCache {
        Map<String,Shape> cache = new Hashtable<>();

        public Shape getShape(String type) {
            if(cache.isEmpty()) {
                loadCache();
            }
            return (Shape) cache.get(type).clone();
        }
        private void loadCache() {
            Shape shape = new Rectangle();
            shape.setId("1");
            shape.setType("rectangle");
            cache.put(shape.getId(),shape);
            shape = new Square();
            shape.setId("2");
            shape.setType("square");
            cache.put(shape.getId(),shape);
            shape = new Circle();
            shape.setId("3");
            shape.setType("circle");
            cache.put(shape.getId(),shape);
        }
    }

    public static void main(String[] args) {
        ShapeCache shapeCache = new ShapeCache();
        System.out.println(shapeCache.getShape("1").getType());
        System.out.println(shapeCache.getShape("2").getType());
        System.out.println(shapeCache.getShape("3").getType());
    }
}
