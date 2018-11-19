package cn.bdqn.gaobingfa.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table
public class ProductStock implements Serializable {

    private String productId;

    private String orderId;
    @Value("0")
    private int orders;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private int stock;

    private int products;

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
