package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderService {
    private MailService mailService;
    private OrderRequest orderRequest;
    private OrderRepository orderRepository;

    public ProductOrderService(final MailService mailService,
                               final OrderRequest orderRequest,
                               final OrderRepository orderRepository) {
        this.mailService = mailService;
        this.orderRequest = orderRequest;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderRequest.getOrder(orderRequest.getUser(), orderRequest.getOrderDate());

        if(isOrdered) {
            mailService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getOrderDate());
        }
        return new OrderDto(orderRequest.getUser(), isOrdered);
    }

    public static void main(String[] args) {
        Customer customer = new Customer("John", "Smith");

        LocalDateTime orderDate = LocalDateTime.of(2018, 12, 27, 4, 54);

        OrderRequest ordReq = new OrderRequest(customer, orderDate);

        ProductOrderService productOrderService = new ProductOrderService(new MailService(), ordReq, new OrderDbMySql());

        productOrderService.process(ordReq);
    }
}
