package VirtualProxy;

public class RealImage implements Image {
    private String filename;
    private int fileSize; // KB
    private String resolution;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
        // Giả lập thông tin ảnh
        this.fileSize = (int) (Math.random() * 5000) + 1000; // 1-6MB
        this.resolution = "4000x3000";
    }

    private void loadFromDisk() {
        System.out.println("Đang tải ảnh: " + filename);
        // Giả lập thời gian tải
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Đã tải xong: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Hiển thị ảnh: " + filename);
        System.out.println("Độ phân giải: " + resolution);
        System.out.println("Kích thước: " + fileSize + "KB");
    }

    @Override
    public String getImageInfo() {
        return String.format("Ảnh: %s | %s | %dKB", filename, resolution, fileSize);
    }
}
