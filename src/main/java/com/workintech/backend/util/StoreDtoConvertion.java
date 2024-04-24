package com.workintech.backend.util;

import com.workintech.backend.dto.StoreResponse;
import com.workintech.backend.entity.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreDtoConvertion {

    public static List<StoreResponse> convertStoreList(List<Store> stores){
        List<StoreResponse> storeResponses = new ArrayList<>();

        stores.stream().forEach(store -> storeResponses.add(new StoreResponse(store.getId(),store.getName()
                ,store.getPhone(),store.getTaxNo(),store.getBankAccount(),store.getProducts(),store.getUser().getId())));
        return storeResponses;
    }

    public static StoreResponse convertStore(Store store){
        return new StoreResponse(store.getId(),store.getName()
                ,store.getPhone(),store.getTaxNo(),store.getBankAccount(),store.getProducts(),store.getUser().getId());
    }
}
