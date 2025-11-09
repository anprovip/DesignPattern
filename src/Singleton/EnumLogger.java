package Singleton;

public enum EnumLogger {
    INSTANCE;

    private EnumLogger() {
        // khởi tạo nếu cần (private, gọi bởi JVM)
    }

    public void log(String msg) {
        System.out.printf("[%s] %s%n", Thread.currentThread().getName(), msg);
    }

    // giúp debug: trả về identity hash code để kiểm tra instance duy nhất
    public int identity() {
        return System.identityHashCode(this);
    }
}
