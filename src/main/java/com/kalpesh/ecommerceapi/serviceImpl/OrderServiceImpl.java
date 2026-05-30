package com.kalpesh.ecommerceapi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kalpesh.ecommerceapi.entity.Cart;
import com.kalpesh.ecommerceapi.entity.CartItem;
import com.kalpesh.ecommerceapi.entity.Order;
import com.kalpesh.ecommerceapi.entity.OrderItem;
import com.kalpesh.ecommerceapi.entity.Product;
import com.kalpesh.ecommerceapi.entity.User;
import com.kalpesh.ecommerceapi.repository.CartRepository;
import com.kalpesh.ecommerceapi.repository.OrderRepository;
import com.kalpesh.ecommerceapi.repository.ProductRepository;
import com.kalpesh.ecommerceapi.repository.UserRepository;
import com.kalpesh.ecommerceapi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CartRepository cartRepository,
                            ProductRepository productRepository,
                            UserRepository userRepository) {

        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order placeOrder(Long userId) {

        // 1. Get cart
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        if (cart.getItems() == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        // 2. Get user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 3. Create order
        Order order = new Order();
        order.setUser(user);
        order.setStatus("PENDING");

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        // 4. Convert cart → order items
        for (CartItem cartItem : cart.getItems()) {

            Product product = productRepository.findById(cartItem.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(product.getPrice());
            item.setOrder(order);

            orderItems.add(item);

            total += product.getPrice() * cartItem.getQuantity();
        }

        order.setItems(orderItems);
        order.setTotalAmount(total);

        // 5. Save order (cascade saves items)
        Order savedOrder = orderRepository.save(order);

        // 6. Clear cart properly
        cart.getItems().clear();
        cartRepository.save(cart);

        return savedOrder;
    }
}