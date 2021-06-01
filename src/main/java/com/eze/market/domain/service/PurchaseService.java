package com.eze.market.domain.service;

import com.eze.market.domain.PurchaseDomain;
import com.eze.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDomain> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDomain>> getByClient(String clientId) {
        return purchaseRepository.getByClientId(clientId);
    }

    public PurchaseDomain save(PurchaseDomain purchase) {
        return purchaseRepository.save(purchase);
    }
}
