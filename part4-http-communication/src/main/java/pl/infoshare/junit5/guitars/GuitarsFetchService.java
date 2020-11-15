package pl.infoshare.junit5.guitars;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5.guitars.client.Guitar;
import pl.infoshare.junit5.guitars.client.GuitarShopClient;
import pl.infoshare.junit5.guitars.model.AvailableGuitar;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuitarsFetchService {

    private final GuitarShopClient guitarShopClient;

    public GuitarsFetchService(GuitarShopClient guitarShopClient) {
        this.guitarShopClient = guitarShopClient;
    }

    public List<AvailableGuitar> fetchAllGuitars() {
        return guitarShopClient.getGuitars()
                .stream()
                .filter(Guitar::isAvailable)
                .map(g -> new AvailableGuitar(g.getId(), g.getName(), g.getPrice()))
                .collect(Collectors.toList());
    }
}
