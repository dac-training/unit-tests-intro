package pl.infoshare.junit5.guitars;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.junit5.guitars.model.AvailableGuitar;

import java.util.List;

@RestController
public class GuitarsController {

    private final GuitarsFetchService guitarsFetchService;
    private final GuitarPurchaseService guitarPurchaseService;

    public GuitarsController(GuitarsFetchService guitarsFetchService, GuitarPurchaseService guitarPurchaseService) {
        this.guitarsFetchService = guitarsFetchService;
        this.guitarPurchaseService = guitarPurchaseService;
    }

    @GetMapping("/guitars")
    public List<AvailableGuitar> getGuitars() {
        return guitarsFetchService.fetchAllGuitars();
    }

    @PostMapping("/guitars/{id}/purchase")
    public void purchaseGuitar(@PathVariable String id) {
        guitarPurchaseService.purchase(id);
    }
}
