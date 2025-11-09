package VirtualProxy;

// Proxy - Kiểm soát truy cập đến RealImage
public class ImageProxy implements Image {
    private String filename;
    private RealImage realImage;
    private boolean isThumbnailLoaded;
    private String thumbnailInfo;

    public ImageProxy(String filename) {
        this.filename = filename;
        this.isThumbnailLoaded = false;
        loadThumbnail();
    }

    private void loadThumbnail() {
        System.out.println("Đang tải thumbnail cho: " + filename);
        // Giả lập thông tin thumbnail
        this.thumbnailInfo = String.format("Thumbnail: %s | 200x150 | 50KB", filename);
        this.isThumbnailLoaded = true;
        System.out.println("Đã tải thumbnail: " + filename);
    }

    private void loadRealImage() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("Hiển thị thumbnail - Click để xem ảnh gốc");
            System.out.println(thumbnailInfo);
        } else {
            realImage.display();
        }
    }

    @Override
    public String getImageInfo() {
        if (realImage == null) {
            return thumbnailInfo;
        } else {
            return realImage.getImageInfo();
        }
    }

    // Phương thức để "click xem ảnh gốc" - Lazy Loading
    public void loadFullImage() {
        System.out.println("\n Người dùng click xem ảnh gốc!");
        loadRealImage();
    }

    // Kiểm tra xem ảnh gốc đã được tải chưa
    public boolean isFullImageLoaded() {
        return realImage != null;
    }
}
