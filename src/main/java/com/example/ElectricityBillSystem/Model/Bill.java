package com.example.ElectricityBillSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "month")
    private String month;
    @Min(value = 1, message = " Units must Be Greater Than 0")
    @Column(name = "units")
    private Integer units;
    @Column(name = "Amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
