package VirtualProxy;

import java.util.Scanner;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        ProductGallery gallery = new ProductGallery();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + "=" .repeat(50));
            System.out.println("🏪 CỬA HÀNG TRỰC TUYẾN");
            System.out.println("=" .repeat(50));
            System.out.println("2. Xem chi tiết sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    gallery.displayThumbnails();
                    break;

                case 2:
                    System.out.print("Nhập số thứ tự sản phẩm: ");
                    int productIndex = scanner.nextInt();
                    gallery.viewProductDetail(productIndex);
                    break;

                case 3:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
