package pl.infoshare.junit5._4_exercise.names;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._4_exercise.DateParser;
import pl.infoshare.junit5._4_exercise.model.AddNamesRequest;

@Component
public class NameDayCreateService {

    private final DateParser dateParser;
    private final NameDayRepository nameDayRepository;

    public NameDayCreateService(DateParser dateParser, NameDayRepository nameDayRepository) {
        this.dateParser = dateParser;
        this.nameDayRepository = nameDayRepository;
    }

    public void addNamesToDate(String stringDate, AddNamesRequest addNamesRequest) {
        var date = dateParser.parse(stringDate);
        nameDayRepository.addToDate(date, addNamesRequest.getNames());
    }
}
