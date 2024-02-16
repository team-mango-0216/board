package org.teammango.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardListAllDTO {

    private int post_id;

    private String title;

    private String content;


}
