package com.eze.market.persistance.crud;

import com.eze.market.persistance.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository <Purchase, Integer> {

    Optional<List<Purchase>> findByClientId(String clientId);
}
