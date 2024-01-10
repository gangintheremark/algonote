package com.algorithm.Algonote.dto;

import lombok.*;

@Builder
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDTO {
    private String title;
    private String text;
    private String code;
    private String solved;
    private String language;
    private String problemSite;
    private String difficulty;
//    private String category;
}
