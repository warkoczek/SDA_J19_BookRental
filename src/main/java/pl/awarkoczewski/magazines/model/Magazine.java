package pl.awarkoczewski.magazines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Magazine {

    private Long id;
    private String title;
    private MGenre mGenre;
    private IssueFrequency issueFrequency;
}
