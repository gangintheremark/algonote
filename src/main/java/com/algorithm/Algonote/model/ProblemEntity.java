package com.algorithm.Algonote.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="problem")
@Entity
public class ProblemEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemNum;
    private String userid;
    private String title;
    private String text;
    private String code;
    private String solved;
    private String language;
    private String problemSite;
    private String difficulty;
    private String category;
}
