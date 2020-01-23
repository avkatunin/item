package ru.andreykatunin.controller;

import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.Item;
import ru.andreykatunin.services.item.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "/get", produces="application/json", consumes="application/json")
    public List<Item> getItems(@RequestBody  Item item) {
        return itemService.getItems(item);
    }

    @GetMapping(value = "/ok")
    public String getOk() {
        return "ok";
    }
}
