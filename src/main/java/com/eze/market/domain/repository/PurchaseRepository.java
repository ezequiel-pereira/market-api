package com.eze.market.domain.repository;

import com.eze.market.domain.PurchaseDomain;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDomain> getAll();
    Optional<List<PurchaseDomain>> getByClientId(String clientId);
    PurchaseDomain save(PurchaseDomain pd);
}
