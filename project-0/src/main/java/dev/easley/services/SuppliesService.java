package dev.easley.services;

import dev.easley.models.User;
import dev.easley.services.repositories.SuppliesRepo;
import dev.easley.services.repositories.SupplyRequestRepo;

public class SuppliesService {

    SuppliesRepo SuppliesRepo = new SuppliesRepo();
    SupplyRequestRepo supplyRequestRepo = new SupplyRequestRepo();





    public boolean supplyRequestList() {

        if (true) {

            supplyRequestRepo.getAllSupply();
            return true;
        }
        return false;
    }


    public boolean createSupplies(String resources, Integer resource_amount, User user) {
        if (resources.equals("Medical") || resources.equals("Food") || resources.equals("Materials")){
            SuppliesRepo.createSupplies(resources, resource_amount, user);
            return true;
        }
        return false;
    }


    public boolean getSuppliesById(Integer user_id) {
        if (true) {
            SuppliesRepo.getSupplyById(user_id);
            return true;
        }
        return false;
    }
}


