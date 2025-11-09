package Singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

public class EnumSingletonLoggerTest {

    public static void main(String[] args) {
        System.out.println("=== Kiểm tra Enum singleton logger ===\n");

        // 1) Thử Reflection
        testReflection();

        // 2) Thử Serialization / Deserialization
        testSerialization();

        // 3) Thử clone (bằng reflection gọi Object.clone)
        testClone();

        // 4) Thread-safety: chạy nhiều thread lấy instance và so sánh
        testThreadSafety();
    }

    private static void testReflection() {
        System.out.println("1) Tấn công bằng Reflection:");
        try {
            // Chữ ký constructor của Enum: (String name, int ordinal) - nhưng không thể tạo enum bằng reflection
            Constructor<EnumLogger> ctor = EnumLogger.class.getDeclaredConstructor(String.class, int.class);
            ctor.setAccessible(true);
            // Thử tạo một thể hiện mới (sẽ ném IllegalArgumentException)
            EnumLogger fake = ctor.newInstance("FAKE", 0);
            System.out.println("Tấn công Reflection thành công (!) - instance giả: " + fake);
        } catch (NoSuchMethodException e) {
            System.out.println("Ngoại lệ NoSuchMethodException: " + e);
        } catch (InvocationTargetException e) {
            System.out.println("Ngoại lệ InvocationTargetException: " + e.getCause());
        } catch (IllegalAccessException e) {
            System.out.println("Ngoại lệ IllegalAccessException: " + e);
        } catch (InstantiationException e) {
            System.out.println("Ngoại lệ InstantiationException: " + e);
        } catch (IllegalArgumentException e) {
            // Đây là kết quả mong đợi: Không thể tạo đối tượng enum bằng reflection
            System.out.println("IllegalArgumentException (đây là kết quả mong đợi) -> reflection không thể tạo instance enum: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ngoại lệ khác: " + e);
        }
        System.out.println();
    }

    private static void testSerialization() {
        System.out.println("2) Kiểm tra Serialization / Deserialization:");
        try {
            EnumLogger instance = EnumLogger.INSTANCE;
            System.out.println("Identity (mã định danh) gốc: " + instance.identity());

            // serialize ra mảng byte
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(instance);
            }

            // deserialize
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
                Object deserialized = ois.readObject();
                System.out.println("Identity (mã định danh) sau khi deserialize: " + System.identityHashCode(deserialized));
                System.out.println("Vẫn là 1 instance sau khi deserialize? " + (deserialized == instance));
            }
        } catch (Exception e) {
            System.out.println("Kiểm tra serialization thất bại: " + e);
        }
        System.out.println();
    }

    private static void testClone() {
        System.out.println("3) Thử clone (qua reflection gọi Object.clone):");
        try {
            EnumLogger instance = EnumLogger.INSTANCE;
            Method m = Object.class.getDeclaredMethod("clone");
            m.setAccessible(true);
            Object cloned = m.invoke(instance); // có nhiều lý do để thất bại
            System.out.println("Clone thành công (không mong đợi): " + cloned);
        } catch (Exception e) {
            System.out.println("Ngoại lệ khác: " + e);
        }
        System.out.println();
    }

    private static void testThreadSafety() {
        System.out.println("4) Kiểm tra Thread-safety:");

        final int threads = 3;
        final int tasks = 10;
        ExecutorService es = Executors.newFixedThreadPool(threads);
        Set<Integer> identities = Collections.newSetFromMap(new ConcurrentHashMap<>());

        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < tasks; i++) {
            callables.add(() -> {
                EnumLogger logger = EnumLogger.INSTANCE;
                // log gì đó
                logger.log("xin chào từ task ["+ logger.identity()+"]");
                // lưu lại mã identity
                identities.add(logger.identity());
                return null;
            });
        }

        try {
            es.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }

        System.out.println("Các mã identity duy nhất được nhìn thấy từ các luồng: " + identities);
        if (identities.size() == 1) {
            System.out.println("Tất cả các luồng đều thấy cùng một instance -> singleton an toàn (như mong đợi).");
        } else {
            System.out.println("Phát hiện nhiều identity (!) -> điều không mong đợi đối với enum singleton.");
        }

        System.out.println();
    }
}