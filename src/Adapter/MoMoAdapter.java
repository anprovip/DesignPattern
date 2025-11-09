package Adapter;

public class MoMoAdapter extends ZaloPayService {
    private MomoService momoService;

    public MoMoAdapter(MomoService momoService) {
        this.momoService = momoService;
    }

    @Override
    public void makePayment(double amount) {

        System.out.println("Chuyển đổi thanh toan sang MOMO...");
        momoService.sendPayment(amount);
    }
}
