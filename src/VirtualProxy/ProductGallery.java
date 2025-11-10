package VirtualProxy;

import java.util.*;

// Client sử dụng Proxy
public class ProductGallery {
    private List<ImageProxy> productImages;

    public ProductGallery() {
        this.productImages = new ArrayList<>();
        initializeGallery();
    }

    private void initializeGallery() {
        // Thêm các ảnh sản phẩm vào gallery
        productImages.add(new ImageProxy("product_001.jpg"));
        productImages.add(new ImageProxy("product_002.jpg"));
        productImages.add(new ImageProxy("product_003.jpg"));
        productImages.add(new ImageProxy("product_004.jpg"));
    }

    public void displayThumbnails() {
        System.out.println("=" .repeat(50));
        System.out.println("GALLERY SẢN PHẨM - HIỂN THỊ THUMBNAIL");
        System.out.println("=" .repeat(50));

        for (int i = 0; i < productImages.size(); i++) {
            ImageProxy image = productImages.get(i);
            System.out.printf("%d. %s\n", i + 1, image.getImageInfo());
        }
    }

    public void viewProductDetail(int index) {
        if (index < 1 || index > productImages.size()) {
            System.out.println("Sản phẩm không tồn tại!");
            return;
        }

        ImageProxy image = productImages.get(index - 1);
        System.out.println("\n" + "=" .repeat(50));
        System.out.println("CHI TIẾT SẢN PHẨM");
        System.out.println("=" .repeat(50));

        // Lazy loading - chỉ tải ảnh gốc khi click xem chi tiết
        if (!image.isFullImageLoaded()) {
            image.loadFullImage();
        }

        image.display();
    }
}
