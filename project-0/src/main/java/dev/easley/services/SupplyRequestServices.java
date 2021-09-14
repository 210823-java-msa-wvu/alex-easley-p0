package dev.easley.services;

import dev.easley.services.repositories.SuppliesRepo;
import dev.easley.services.repositories.SupplyRequestRepo;

public class SupplyRequestServices {
    dev.easley.services.repositories.SupplyRequestRepo SupplyRequestRepo = new SupplyRequestRepo();

    public boolean requestSupplies(String resource, Integer resource_amount, Integer priority_level, Integer requester_id) {


        if (resource.equals("Medical") || resource.equals("Food") || resource.equals("Materials")){

            SupplyRequestRepo.makeRequest(resource, resource_amount, priority_level, requester_id);
            return true;
        }
        return false;
    }
    public boolean updateSupplies(Integer citizen_id, String resources) {
        if (resources.equals("Medical") || resources.equals("Food") || resources.equals("Materials")) {

            SupplyRequestRepo.updateSupplies(resources, citizen_id);
            return true;
        }
        return false;
    }
}
