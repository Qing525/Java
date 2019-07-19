package singleton;

public class StaticInnerSingleton {

    private StaticInnerSingleton() {
    }


    private static class Singleton1 {

        private static StaticInnerSingleton Instance = new StaticInnerSingleton();

    }

    public static StaticInnerSingleton getInstance() {

        return Singleton1.Instance;

    }


}
