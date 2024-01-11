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
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "problemNum")
	    private int problemNum;

	    @Column(name = "userid", length = 20)
	    private String userid;

	    @Column(name = "title", length = 50, nullable = false)
	    private String title;

	    @Column(name = "text", length = 4000)
	    private String text;

	    @Column(name = "code", length = 30000)
	    private String code;

	    @Column(name = "solved", length = 20, nullable = false)
	    private String solved;

	    @Column(name = "language", length = 10, nullable = false)
	    private String language;

	    @Column(name = "problemSite", length = 20, nullable = false)
	    private String problemSite;

	    @Column(name = "difficulty", length = 20, nullable = false)
	    private String difficulty;

	    @Column(name = "category", length = 30)
	    private String category;

//	    @ManyToOne
//	    @JoinColumn(name = "userid", referencedColumnName = "userid", insertable = false, updatable = false)
//	    private Member member;

}
