
# 12 Design Pattern "Must-Haves" để Demo

## 1. Nhóm Khởi tạo (Creational)

### 1. Singleton
**Tại sao chọn:** Cực kỳ phổ biến. Dùng để quản lý các tài nguyên chia sẻ (shared resources) như kết nối cơ sở dữ liệu, file cấu hình, hay logger.

### 2. Factory Method
**Tại sao chọn:** Rất quan trọng để giảm sự phụ thuộc cứng (hard-coded dependencies). Giúp chương trình linh hoạt trong việc quyết định tạo đối tượng nào lúc runtime.

### 3. Builder
**Tại sao chọn:** Giải quyết vấn đề "Constructor hell" (constructor có quá nhiều tham số). Rất phổ biến khi tạo các đối tượng phức tạp, ví dụ như tạo một User với nhiều trường tùy chọn.

### 4. Prototype
**Tại sao chọn:** Hữu ích khi việc tạo một đối tượng mới rất tốn kém (ví dụ: phải gọi API hoặc query database). Thay vào đó, bạn chỉ cần "nhân bản" (clone) một đối tượng có sẵn.

| Thành phần            | Vai trò                             | Trong ví dụ ProductCache               |
| --------------------- | ----------------------------------- | -------------------------------------- |
| **Prototype**         | Khai báo `clone()`                  | Interface `Prototype`                  |
| **ConcretePrototype** | Cài đặt `clone()`                   | Class `Product`                        |
| **Client**            | Dùng `clone()` để tạo đối tượng mới | `ProductCache` và `PrototypeCacheDemo` |

## 2. Nhóm Cấu trúc (Structural)

### 5. Adapter  
**Tại sao chọn:** Là "keo dán" của phần mềm. Gần như dự án nào cũng cần đến nó để tích hợp các thư viện bên thứ ba hoặc làm việc với code cũ (legacy code) có giao diện không tương thích.

### 6. Decorator
**Tại sao chọn:** Rất trực quan và dễ hiểu (như "gói quà" cho một đối tượng). Cho phép bạn thêm chức năng mới vào đối tượng một cách linh hoạt mà không cần kế thừa.

### 7. Facade
**Tại sao chọn:** Giúp che giấu sự phức tạp. Bất kỳ khi nào bạn tạo một "service" đơn giản để gọi một loạt các hệ thống con phức tạp bên dưới, đó chính là Facade.

### 8. Proxy
**Tại sao chọn:** Một mẫu mạnh mẽ để kiểm soát quyền truy cập. Các ví dụ kinh điển là Lazy Loading (chỉ tải ảnh khi cần), Caching, hoặc kiểm tra quyền (security check).

## 3. Nhóm Hành vi (Behavioral)

### 9. Observer
**Tại sao chọn:** Nền tảng của lập trình hướng sự kiện (event-driven). Bất kỳ cơ chế "thông báo" (notification), "lắng nghe sự kiện" (event listener) nào cũng đều dùng mẫu này.

### 10. Strategy
**Tại sao chọn:** Cực kỳ linh hoạt để thay đổi "chiến lược" hoặc "thuật toán" lúc runtime. Ví dụ cổ điển là chọn phương thức thanh toán hoặc cách thức vận chuyển.

### 11. Template Method
**Tại sao chọn:** Một cách tuyệt vời để định nghĩa một "khung sườn" (skeleton) của thuật toán và để các lớp con tự định nghĩa các bước chi tiết. Rất phổ biến trong các framework.

### 12. Command
**Tại sao chọn:** Đóng gói một yêu cầu thành một đối tượng. Đây là chìa khóa để thực hiện các chức năng như Undo/Redo, hàng đợi tác vụ (task queuing), hoặc ghi log Giao dịch (transaction logging).
