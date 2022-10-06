package sk.ness.academy.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Comment {
    private int id;

    private String authorName;

    private String text;

}
