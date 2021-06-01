package com.eze.market.persistance;

import com.eze.market.domain.PurchaseDomain;
import com.eze.market.persistance.crud.PurchaseCrudRepository;
import com.eze.market.persistance.entity.Purchase;
import com.eze.market.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements com.eze.market.domain.repository.PurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<PurchaseDomain> getAll() {
        return purchaseMapper.toPurchaseDomainList((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDomain>> getByClientId(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(purchase -> purchaseMapper.toPurchaseDomainList(purchase));
    }

    @Override
    public PurchaseDomain save(PurchaseDomain purchase) {
        Purchase purchaseHolder = purchaseMapper.toPurchase(purchase);
        purchaseHolder.getPurchaseProducts().forEach(product -> product.setPurchase(purchaseHolder));
        return purchaseMapper.toPurchaseDomain(purchaseCrudRepository.save(purchaseHolder));
    }
}
