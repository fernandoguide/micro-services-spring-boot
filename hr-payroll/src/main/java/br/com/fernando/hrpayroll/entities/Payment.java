package br.com.fernando.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private String name;
    private Double dailyIncome;
    private Integer days;


    public double getTotal(){
       return  days * dailyIncome;
    }

}
