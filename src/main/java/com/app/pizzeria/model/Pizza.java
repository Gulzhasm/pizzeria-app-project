package com.app.pizzeria.model;

import com.app.pizzeria.enums.Sauce;
import com.app.pizzeria.enums.Cheese;
import com.app.pizzeria.enums.Topping;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Pizza {

    private UUID id;
    private List<Cheese> cheeseList;
    private List<Sauce> sauceList;
    private List<Topping> toppingList;

}
