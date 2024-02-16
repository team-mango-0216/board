package org.teammango.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class mango_board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

}
