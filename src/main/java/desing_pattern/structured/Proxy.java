package desing_pattern.structured;

public class Proxy {

    interface Subject {
        void request();
    }

    static class RealSubject implements Subject{

        @Override
        public void request() {
            System.out.println("do something ....");
        }
    }

    static class SubjectStatiwcProxy implements Subject {

        Subject subject;

        public SubjectStatiwcProxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            System.out.println("I'm prepare do something");
            subject.request();
            System.out.println("I'm finish work.exit...");
        }
    }

    static class SubjectDynamicProxy {

        Subject subject;


    }

}
