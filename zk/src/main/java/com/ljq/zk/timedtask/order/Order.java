package com.ljq.zk.timedtask.order;

/**
 * @author LJQ
 * @date 2019/7/24 16:16
 **/
public class Order {
    private Long orderId;
    private String status;

    public Order(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
