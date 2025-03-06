package com.example.BookUrRide.strategies.impl;

import com.example.BookUrRide.entities.Driver;
import com.example.BookUrRide.entities.Payment;
import com.example.BookUrRide.entities.enums.PaymentStatus;
import com.example.BookUrRide.entities.enums.TransactionMethod;
import com.example.BookUrRide.repositories.PaymentRepository;
import com.example.BookUrRide.services.WalletService;
import com.example.BookUrRide.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission, null,
                payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
