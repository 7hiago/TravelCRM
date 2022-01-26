package org.laba2.services;

import org.laba2.dao.*;
import org.laba2.dto.CreateOrderDTO;
import org.laba2.dto.EditOrderDTO;
import org.laba2.dto.ShowOrderDTO;
import org.laba2.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private TourService tourService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountingService accountingService;

    @Autowired
    private ManagerService managerService;

    private final OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public CreateOrderDTO createNewOrder() {
        return new CreateOrderDTO();
    }

    public void saveNewOrder(CreateOrderDTO createOrderDTO) {

        createOrderDTO.getTour().setTourId("TR-" + UUID.randomUUID());
        tourService.createNewTour(createOrderDTO.getTour());

        createOrderDTO.getCustomer().setCustomerId("CT-" + UUID.randomUUID());
        customerService.createNewCustomer(createOrderDTO.getCustomer());

        createOrderDTO.getAccounting().setAccountingId("AC-" + UUID.randomUUID());
        accountingService.createNewAccounting(createOrderDTO.getAccounting());

        Order order = new Order();
        order.setTourId(createOrderDTO.getTour().getTourId());
        order.setCustomerId(createOrderDTO.getCustomer().getCustomerId());
        order.setManagerId(createOrderDTO.getSelectedManagerId());
        order.setAccountingId(createOrderDTO.getAccounting().getAccountingId());
        order.setDate(createOrderDTO.getDate());
        order.setStatus(createOrderDTO.getStatus());
        orderDAO.createOrder(order);
    }

    public List<ShowOrderDTO> getAvailableOrders() {
        List<ShowOrderDTO> showOrderDTOList = new ArrayList<>();
        List<Order> orderList = orderDAO.getOrders();
        for (Order order : orderList) {

            showOrderDTOList.add(new ShowOrderDTO(
                    order.getOrderId(),
                    tourService.getTourById(order.getTourId()),
                    customerService.getCustomerById(order.getCustomerId()),
                    managerService.getManagerById(order.getManagerId()),
                    accountingService.getAccountingById(order.getAccountingId()),
                    order.getDate(),
                    order.getStatus()));
        }
        return showOrderDTOList;
    }

    public ShowOrderDTO getOrderById(int orderId) {
        Order order = orderDAO.getOrder(orderId);
        return new ShowOrderDTO(
                order.getOrderId(),
                tourService.getTourById(order.getTourId()),
                customerService.getCustomerById(order.getCustomerId()),
                managerService.getManagerById(order.getManagerId()),
                accountingService.getAccountingById(order.getAccountingId()),
                order.getDate(),
                order.getStatus());
    }

    public void updateOrderById(int orderId, EditOrderDTO editOrderDTO) {
        Order order = orderDAO.getOrder(orderId);
        order.setManagerId(editOrderDTO.getManagerId());
        order.setDate(editOrderDTO.getDate());
        order.setStatus(editOrderDTO.getStatus());
        orderDAO.updateOrder(orderId, order);
    }

    public void deleteOrderById(int orderId) {
        orderDAO.removeOrder(orderId);
    }
}
