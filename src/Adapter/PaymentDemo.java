package Adapter;

public class PaymentDemo {
    public static void main(String[] args) {
        // Thay vì dùng NganLuong thật, ta dùng PayPalAdapter
        ZaloPayService payment = new MoMoAdapter(new MomoService());

        // Code client KHÔNG ĐỔI
        payment.makePayment(500000);
    }
}
