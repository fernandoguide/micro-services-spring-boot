package br.com.fernando.hrpayroll.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.hrpayroll.entities.Payment;
import br.com.fernando.hrpayroll.entities.Worker;
import br.com.fernando.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long wrokerId, int days) {
		Worker worker = workerFeignClient.findByYd(wrokerId).getBody();
		return new Payment(Objects.requireNonNull(worker).getName(), worker.getDailyIncome(), days);
	}

}
