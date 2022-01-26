package org.laba2.dto;

public class EditOrderDTO {

    private String managerId;
    private String date;
    private String status;

    public EditOrderDTO() {}

    public EditOrderDTO(String managerId, String date, String status) {
        this.managerId = managerId;
        this.date = date;
        this.status = status;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
