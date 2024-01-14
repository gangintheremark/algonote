package com.algorithm.Algonote.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "problem")
@Entity
public class ProblemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problemNum")
    private int problemNum;

    @Column(name = "userid", length = 20)
    private String userid;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;

    @Column(name = "code", columnDefinition = "LONGTEXT")
    private String code;

    @Column(name = "solved", length = 20, nullable = false)
    private String solved;

    @Column(name = "language", length = 10, nullable = false)
    private String language;

    @Column(name = "problemSite", length = 20, nullable = false)
    private String problemSite;

    @Column(name = "difficulty", length = 20, nullable = false)
    private String difficulty;

    @ElementCollection
    @CollectionTable(name = "problem_categories")
    @Column(name = "category")
    private List<String> category;

//	    @ManyToOne
//	    @JoinColumn(name = "userid", referencedColumnName = "userid", insertable = false, updatable = false)
//	    private Member member;

}
