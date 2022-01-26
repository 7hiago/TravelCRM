package org.laba2.controllers;

import org.laba2.dto.CreateOrderDTO;
import org.laba2.dto.EditOrderDTO;
import org.laba2.services.ManagerService;
import org.laba2.services.OrderService;
import org.laba2.services.TouroperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/showOrder/{orderId}")
    public ModelAndView showOrder(@PathVariable("orderId") int orderId) {
        return new ModelAndView("./orders/showOrder", "order", orderService.getOrderById(orderId));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createCompleteOrder")
    public String createCompleteOrder(Model model) {
        model.addAttribute("managers", managerService.getAvailableManagers());
        model.addAttribute("touroperators",touroperatorService.getAvailableTouroperators());
        model.addAttribute("createOrderDTO", new CreateOrderDTO());
        return "./orders/createCompleteOrder";
    }

    @PostMapping("/saveCreatedCompleteOrder")
    public ModelAndView saveCreatedCompleteOrder(@ModelAttribute CreateOrderDTO createOrderDTO) {
        orderService.saveNewOrder(createOrderDTO);
        return new ModelAndView("redirect:/orders/showOrders");
    }

//    @GetMapping("/{orderId}/editOrder")
//    public ModelAndView editOrder(@PathVariable("orderId") int orderId) {
//        return new ModelAndView("./orders/editOrder", "command", orderService.getOrderById(orderId));
//    }

    @GetMapping("/{orderId}/editOrder")
    public String editOrder(Model model, @PathVariable("orderId") int orderId) {
        model.addAttribute("managers", managerService.getAvailableManagers());
        model.addAttribute("order", orderService.getOrderById(orderId));
        model.addAttribute("editOrderDTO", new EditOrderDTO());
        return "./orders/editOrder";
    }

    @PatchMapping("/saveEditedOrder/{orderID}")
    public ModelAndView saveEditedOrder(@ModelAttribute EditOrderDTO editOrderDTO, @PathVariable("orderID") int orderId) {
        orderService.updateOrderById(orderId, editOrderDTO);
        return new ModelAndView("redirect:/orders/showOrders");
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ModelAndView deleteOrder(@PathVariable("orderId") int orderId) {
        orderService.deleteOrderById(orderId);
        return new ModelAndView("redirect:/orders/showOrders");
    }
}
