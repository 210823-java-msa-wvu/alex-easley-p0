package dev.easley.services;

import dev.easley.models.User;
import dev.easley.services.repositories.SuppliesRepo;

public class SuppliesService {

    SuppliesRepo SuppliesRepo = new SuppliesRepo();


    public boolean updateSupplies(Integer citizen_id, String resources) {
        if (resources.equals("Medical") || resources.equals("Food") || resources.equals("Materials")) {

            SuppliesRepo.updateSupplies(resources, citizen_id);
            return true;
        }
        return false;
    }


    public boolean suppliesList() {

        if (true) {

            SuppliesRepo.getAllSupply();
            return true;
        }
        return false;
    }


    public boolean createSupplies(String resources, Integer resource_amount, User user) {
        if (resources.equals("Medical") || resources.equals("Food") || resources.equals("Materials")){
            SuppliesRepo.createSupplies(resources, resource_amount, user);
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


