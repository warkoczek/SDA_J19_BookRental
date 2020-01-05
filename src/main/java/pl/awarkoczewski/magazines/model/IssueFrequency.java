package pl.awarkoczewski.magazines.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum IssueFrequency {

    DAILY("daily"), WEEKLY("weekly"), MONTHLY("monthly");

    private String name;

}
