package hello.core.order;

public interface OrderService {
    // 이러한 매개변수를 주면 최종 order를 반환한다
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
