package com.app.pizzeria.controller;

import com.app.pizzeria.bootstrap.DataGenerator;
import com.app.pizzeria.model.Pizza;
import com.app.pizzeria.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/design")
public class DesignPizzaController {

    private PizzaRepository pizzaRepository;

    public DesignPizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("cheeses", DataGenerator.cheeseTypeList);
        model.addAttribute("sauces", DataGenerator.sauceTypeList);
        model.addAttribute("toppings", DataGenerator.toppingTypeList);
        return "/design";
    }

    @PostMapping("/createPizza")
    public String processPizza(Pizza pizza) {
        pizza.setId(UUID.randomUUID());
        pizzaRepository.createPizza(pizza);
        return "redirect:/orders/current?pizzaId=" + pizza.getId();
    }

}
