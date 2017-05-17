package myapp;

import java.util.List;
import java.util.Random;

import org.opendolphin.core.server.DTO;

import myapp.presentationmodel.person.PersonAtt;
import myapp.service.SomeService;
import myapp.util.DTOMixin;

public class SomeCombinedService implements SomeService, DTOMixin {

    String[] names = {"Virgil Grissom", "Iris Cipriano", "Roger Chaffee",      // Apollo 1, "Edward White"
                      "Walter Schirra", "Donn Eisele" , "Walter Cunningham",  // Apollo 7
                      "Frank Borman"  , "James Lovell", "William Anders",     // Apollo 8
                      "James McDivitt", "David Scott" , "Russel Schweickart", // Apollo 9
                      "Tom Stafford"  , "John Young"  , "Eugene Cernan"};     // Apollo 10

    @Override
    public DTO loadSomeEntity() {
        long id = createNewId();

        Random r = new Random();
        return new DTO(createSlot(PersonAtt.ID      , id                            , id),
                       createSlot(PersonAtt.NAME    , names[r.nextInt(names.length)], id),
                       createSlot(PersonAtt.AGE     , r.nextInt(43)                 , id),
                       createSlot(PersonAtt.IS_ADULT, false                         , id));
    }

    @Override
    public void save(List<DTO> dtos) {
        System.out.println(" Data to be saved");
        dtos.stream()
            .flatMap(dto -> dto.getSlots().stream())
            .map(slot -> String.join(", ", slot.getPropertyName(), slot.getValue().toString(), slot.getQualifier()))
            .forEach(System.out::println);
    }
}
