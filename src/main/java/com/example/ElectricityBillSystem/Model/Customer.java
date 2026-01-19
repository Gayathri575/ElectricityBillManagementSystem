package com.example.ElectricityBillSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId")
    private Long id ;
    @NotBlank(message = "Name is Mandatory")
    @Column(name = "CustomerName")
    private String name ;
    @Email(message= "Inavlid Email")
    @Column(name = "emailID")
    private String email ;
    @NotNull
    @Size(min = 10 , max = 10)
    @Column(name = "CustomerPhNo")
    private String phone ;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Bill> bills ;
}
