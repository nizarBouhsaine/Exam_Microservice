package com.example.studentservice.Reponse;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CourseResponse {
    private Long id;
    private String name;
}
