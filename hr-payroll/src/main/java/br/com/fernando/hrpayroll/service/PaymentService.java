package br.com.fernando.hrpayroll.service;


import br.com.fernando.hrpayroll.entities.Payment;
import br.com.fernando.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PaymentService {

    @Value("${hr.worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long wrokerId,int days){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id",String.valueOf(wrokerId));
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}",Worker.class,uriVariables);
        return new Payment(Objects.requireNonNull(worker).getName(),worker.getDailyIncome(),days);
    }

}
