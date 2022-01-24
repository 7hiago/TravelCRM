package org.laba2.controllers;

import org.laba2.dao.OrderDAO;
import org.laba2.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping("/showOrders")
    public ModelAndView showOrders() {
        return new ModelAndView("./orders/showOrders", "orders", orderDAO.getOrders());
    }

    @GetMapping("/showOrder/{orderId}")
    public ModelAndView showOrder(@PathVariable("orderId") int orderId) {
        return new ModelAndView("./orders/showOrder", "order", orderDAO.getOrder(orderId));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createOrder")
    public ModelAndView createOrder() {
        return new ModelAndView("./orders/createOrder", "command", new Order());
    }

    @PostMapping("/saveCreatedOrder")
    public ModelAndView saveCreatedOrder(@ModelAttribute Order order) {
        orderDAO.createOrder(order);
        return new ModelAndView("redirect:/orders/showOrders");
    }

    @GetMapping("/{orderId}/editOrder")
    public ModelAndView editOrder(@PathVariable("orderId") int orderId) {
        return new ModelAndView("./orders/editOrder", "command", orderDAO.getOrder(orderId));
    }

    @PatchMapping("/saveEditedOrder/{orderID}")
    public ModelAndView saveEditedOrder(@ModelAttribute Order order, @PathVariable("orderID") int orderId) {
        orderDAO.updateOrder(orderId, order);
        return new ModelAndView("redirect:/orders/showOrders");
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ModelAndView deleteOrder(@PathVariable("orderId") int orderId) {
        orderDAO.removeOrder(orderId);
        return new ModelAndView("redirect:/orders/showOrders");
    }
}
