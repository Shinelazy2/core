package hello.core.order;

public interface OrderService {
    /**
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
