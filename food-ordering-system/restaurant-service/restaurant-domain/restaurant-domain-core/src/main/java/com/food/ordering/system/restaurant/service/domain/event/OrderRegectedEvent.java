package com.food.ordering.system.restaurant.service.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.domain.valueobject.RestaurantId;
import com.food.ordering.system.restaurant.service.domain.entity.OrderApproval;

import java.time.ZonedDateTime;
import java.util.List;

public class OrderRegectedEvent extends OrderApprovalEvent{

    private final DomainEventPublisher<OrderRegectedEvent> orderRegectedEventDomainEventPublisher;

    public OrderRegectedEvent(OrderApproval orderApproval,
                              RestaurantId restaurantId,
                              List<String> failureMessages,
                              ZonedDateTime createdAt,
                              DomainEventPublisher<OrderRegectedEvent> orderRegectedEventDomainEventPublisher) {
        super(orderApproval, restaurantId, failureMessages, createdAt);
        this.orderRegectedEventDomainEventPublisher = orderRegectedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        orderRegectedEventDomainEventPublisher.publish(this);
    }
}
