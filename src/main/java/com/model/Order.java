package com.model;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private Date createDate = new Date();
    private Date doneTime;

    @Column(nullable = false)
    private Long paymentMethod;
//    order status: 1 - Đã đặt, đang chờ xác nhận
//				2 - xác nhận thành công, chờ nhận hàng
//				3 - đã hủy
//				4 - giao hàng thành công


    @Column(nullable = false)
    private Long status;

    //customer


    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String lastName;
    private String companyName;//

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false, length = 5000)
    private String address1;
    private String address2;//

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String email;
    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String phone;
    private String note;//

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")      //category - product (n - 1) ok
    private Province province;


//    validation

    public boolean supports(Class<?> clazz) {
        return Order.class.isAssignableFrom(clazz);
    }


    public void validate(Object target, Errors errors) {
        Order tag = (Order) target;
        String nameTag = tag.getAddress1();
        ValidationUtils.rejectIfEmpty(errors, "address1", "name.empty");
        if (nameTag.length() > 250 || nameTag.length() < 2) {
            errors.rejectValue("name", "name.length");
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", doneTime=" + doneTime +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status=" + status +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
