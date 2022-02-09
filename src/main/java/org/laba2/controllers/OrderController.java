package org.laba2.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.dto.CreateOrderDTO;
import org.laba2.dto.ShowOrderDTO;
import org.laba2.entities.Manager;
import org.laba2.services.ManagerService;
import org.laba2.services.OrderService;
import org.laba2.services.TouroperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private TouroperatorService touroperatorService;

    @GetMapping("/showOrders")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public String showOrders(Model model, Principal principal) {
        logger.debug("invocation show orders method");
        Manager manager = managerService.getManagerByLogin(principal.getName());
        if(manager.getRole().equals("ROLE_MANAGER")) {
            model.addAttribute("orders", orderService.getAvailableOrdersForManager(manager.getManagerId()));
        } else {
            model.addAttribute("orders", orderService.getAvailableOrders());
        }
        return "./orders/showOrders";
    }

    @GetMapping("/createOrder")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public String createOrder(Model model) {
        logger.debug("invocation create order method");
        model.addAttribute("touroperators", touroperatorService.getAvailableTouroperators());
        model.addAttribute("createOrderDTO", new CreateOrderDTO());
        return "./orders/createOrder";
    }

    @PostMapping("/saveCreatedOrder")
    public String saveCreatedOrder(@ModelAttribute("createOrderDTO") @Valid CreateOrderDTO createOrderDTO, BindingResult bindingResult, Principal principal, Model model) {
        logger.debug("invocation save created order method");
        if (bindingResult.hasErrors()) {
            logger.debug("save has error");
            model.addAttribute("touroperators", touroperatorService.getAvailableTouroperators());
            return "./orders/createOrder";
        } else {
            logger.debug("save has not error");
            orderService.saveNewOrder(createOrderDTO, principal);
        }
        return "redirect:/orders/showOrders";
    }

    @GetMapping("/{orderId}/editOrder")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public String editOrder(Model model, @PathVariable("orderId") int orderId) {
        logger.debug("invocation edit order method");
        model.addAttribute("managers", managerService.getAvailableManagers());
        model.addAttribute("orderDTO", orderService.getOrderById(orderId));
        return "./orders/editOrder";
    }

    @PatchMapping("/saveEditedOrder/{orderID}")
    public ModelAndView saveEditedOrder(@ModelAttribute ShowOrderDTO showOrderDTO, @PathVariable("orderID") int orderId) {
        logger.debug("invocation save edited order method");
        orderService.editOrderById(orderId, showOrderDTO);
        return new ModelAndView("redirect:/orders/showOrders");
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView deleteOrder(@PathVariable("orderId") int orderId) {
        logger.debug("invocation delete order method");
        orderService.deleteOrderById(orderId);
        return new ModelAndView("redirect:/orders/showOrders");
    }
}