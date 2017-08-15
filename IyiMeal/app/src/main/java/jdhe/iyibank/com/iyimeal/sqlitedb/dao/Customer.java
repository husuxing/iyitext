package jdhe.iyibank.com.iyimeal.sqlitedb.dao;

/**
 * Created by Administrator on 2017/8/8.
 */

public class Customer {
    public Customer(String id,String customerName, String deliveryPhone, String addr, String accessType, String customerRating, String layers, String remark, String contacts) {
        this.id = id;
        this.customerName = customerName;
        this.deliveryPhone = deliveryPhone;
        this.addr = addr;
        this.accessType = accessType;
        this.customerRating = customerRating;
        this.layers = layers;
        this.remark = remark;
        this.contacts = contacts;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*
        *id
        * customerName 客户名称
        * deliveryPhone 送货电话
        * addr 地址
        * accessType 通路类型
        * customerRating 客户等级
        * layers 图层
        * remark 备注
        * contacts 联系人
        */
    private String id;
    private String customerName;
    private String deliveryPhone;
    private String addr;
    private String accessType;
    private String customerRating;
    private String layers;
    private String remark;
    private String contacts;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    public String getLayers() {
        return layers;
    }

    public void setLayers(String layers) {
        this.layers = layers;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
