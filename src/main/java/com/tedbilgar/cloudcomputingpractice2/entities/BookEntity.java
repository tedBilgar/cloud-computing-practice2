package com.tedbilgar.cloudcomputingpractice2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    private Long id;
    private String name;
    private Long pageCount;
    private Double averageMark;
    private String description;
}
