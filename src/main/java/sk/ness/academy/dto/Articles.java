package sk.ness.academy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Articles {
    private int id;

    private String author;

    private String text;

    private String title;

    private Date Timestamp;

}
