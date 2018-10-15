package com.foodhomie.cook.repositories;

import com.foodhomie.cook.models.Cook;
import org.springframework.data.repository.CrudRepository;

public interface CookRepository extends CrudRepository <Cook, Integer> {
}
