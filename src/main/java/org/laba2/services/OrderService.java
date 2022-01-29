package org.laba2.services;


import org.laba2.dao.OrderDAO;
import org.laba2.dto.CreateOrderDTO;
import org.laba2.dto.ShowOrderDTO;
import org.laba2.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public void saveNewOrder(CreateOrderDTO createOrderDTO, Principal principal) {

        tourService.createNewTour(createOrderDTO.getTour());
        customerService.createNewCustomer(createOrderDTO.getCustomer());
        accountingService.createNewAccounting(createOrderDTO.getAccounting());

        Order order = new Order();
        order.setTourId(createOrderDTO.getTour().getTourId());
        order.setCustomerId(createOrderDTO.getCustomer().getCustomerId());
        order.setManagerId(managerService.getManagerByLogin(principal.getName()).getManagerId());
        order.setAccountingId(createOrderDTO.getAccounting().getAccountingId());
        order.setDate(LocalDate.now().toString());
        order.setStatus("Reserved");
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

    public List<ShowOrderDTO> getAvailableOrdersForManager(String managerId) {
        List<ShowOrderDTO> showOrderDTOList = new ArrayList<>();
        List<Order> orderList = orderDAO.getAvailableOrdersForManager(managerId);
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

    public void editOrderById(int orderId, ShowOrderDTO showOrderDTO) {
        Order order = orderDAO.getOrder(orderId);
        order.setManagerId(showOrderDTO.getManager().getManagerId());
        order.setDate(showOrderDTO.getDate());
        order.setStatus(showOrderDTO.getStatus());
        orderDAO.updateOrder(orderId, order);
    }

    public void deleteOrderById(int orderId) {
        Order order = orderDAO.getOrder(orderId);
        orderDAO.removeOrder(orderId);
        tourService.deleteTourById(order.getTourId());
        accountingService.deleteAccountingById(order.getAccountingId());
    }
}
