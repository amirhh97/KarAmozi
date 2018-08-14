package com.example.aebrahimi.firstmvp.Contract;

import com.example.aebrahimi.firstmvp.Model.Item;

import java.util.List;

/**
 * Created by aebrahimi on 8/13/2018 AD.
 */

public interface Contract {
    interface Presenter
    {
         void getListItems();
    }
    interface View
    {
        void ShowItems(List<Item> items);
    }


}
