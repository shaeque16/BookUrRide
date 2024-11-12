package com.example.uber.services.impl;

import com.example.uber.entities.WalletTransaction;
import com.example.uber.repositories.WalletTransactionRepository;
import com.example.uber.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {

        walletTransactionRepository.save(walletTransaction);
    }
}
