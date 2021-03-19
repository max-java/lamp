package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {

    long id;
    Countries country;
    String name;

}
