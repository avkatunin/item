package ru.andreykatunin.services.item;

import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Item;
import ru.andreykatunin.services.dao.ItemDao;

import java.util.List;

@Service
public class ItemService {

    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Item> getItems(Item item) {
        return itemDao.getItemListFromDB(item);
    }
}
