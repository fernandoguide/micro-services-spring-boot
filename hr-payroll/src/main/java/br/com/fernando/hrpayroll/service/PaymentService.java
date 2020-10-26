package br.com.fernando.hrpayroll.service;


import br.com.fernando.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long wrokerId,int days){
        return new Payment("Bob",200.0,days);
    }

}
