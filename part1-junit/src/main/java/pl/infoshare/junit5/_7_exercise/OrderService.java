package pl.infoshare.junit5._7_exercise;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Ćwiczenie 7. Napisz testy dla poniższej klasy wykorzystując bibliotekę Mockito.
 * Upewnij się, że eventy są wysyłane w odpowiedniej kolejności.
 */
public class OrderService {

    private static final Random RANDOM = new Random();

    private final OrderEventSender orderEventSender;
    private final OrderRepositoryService orderRepository;

    public OrderService(OrderEventSender orderEventSender, OrderRepositoryService orderRepository) {
        this.orderEventSender = orderEventSender;
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Basket basket) {
        var id = RANDOM.nextInt();

        orderEventSender.sendEvent(id, OrderEventType.ORDER_PROCESS_STARTED);

        var totalPrice = calculatePrice(basket);
        var discount = calculateDiscount(id, totalPrice);

        orderRepository.save(new Order(id, totalPrice, discount));
        orderEventSender.sendEvent(id, OrderEventType.ORDER_FINISHED);
    }

    private BigDecimal calculateDiscount(Integer id, BigDecimal totalPrice) {
        if (totalPrice.compareTo(BigDecimal.valueOf(50)) > 0) {
            orderEventSender.sendEvent(id, OrderEventType.ORDER_DISCOUNTED);
            return BigDecimal.valueOf(20);
        }

        return BigDecimal.ZERO;
    }

    private BigDecimal calculatePrice(Basket basket) {
        return basket.getItems()
                .stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
