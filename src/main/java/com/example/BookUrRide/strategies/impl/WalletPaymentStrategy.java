package com.example.BookUrRide.strategies.impl;

import com.example.BookUrRide.entities.Driver;
import com.example.BookUrRide.entities.Payment;
import com.example.BookUrRide.entities.Rider;
import com.example.BookUrRide.entities.enums.PaymentStatus;
import com.example.BookUrRide.entities.enums.TransactionMethod;
import com.example.BookUrRide.repositories.PaymentRepository;
import com.example.BookUrRide.services.WalletService;
import com.example.BookUrRide.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {
    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),
                payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),
                driversCut, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
