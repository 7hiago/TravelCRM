package org.laba2.controllers;

import org.laba2.dto.CreateOrderDTO;
import org.laba2.dto.ShowOrderDTO;
import org.laba2.services.ManagerService;
import org.laba2.services.OrderService;
import org.laba2.services.TouroperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private TouroperatorService touroperatorService;

    @GetMapping("/showOrders")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.getAvailableOrders());
        return "./orders/showOrders";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createOrder")
    public String createOrder(Model model) {
        model.addAttribute("managers", managerService.getAvailableManagers());
        model.addAttribute("touroperators",touroperatorService.getAvailableTouroperators());
        model.addAttribute("createOrderDTO", new CreateOrderDTO());
        return "./orders/createOrder";
    }

    @PostMapping("/saveCreatedOrder")
    public ModelAndView saveCreatedOrder(@ModelAttribute CreateOrderDTO createOrderDTO) {
        orderService.saveNewOrder(createOrderDTO);
        return new ModelAndView("redirect:/orders/showOrders");
    }

    @GetMapping("/{orderId}/editOrder")
    public String editOrder(Model model, @PathVariable("orderId") int orderId) {
        model.addAttribute("managers", managerService.getAvailableManagers());
        model.addAttribute("orderDTO", orderService.getOrderById(orderId));
        return "./orders/editOrder";
    }

    @PatchMapping("/saveEditedOrder/{orderID}")
    public ModelAndView saveEditedOrder(@ModelAttribute ShowOrderDTO showOrderDTO, @PathVariable("orderID") int orderId) {
        orderService.editOrderById(orderId, showOrderDTO);
        return new ModelAndView("redirect:/orders/showOrders");
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ModelAndView deleteOrder(@PathVariable("orderId") int orderId) {
        orderService.deleteOrderById(orderId);
        return new ModelAndView("redirect:/orders/showOrders");
    }
}
