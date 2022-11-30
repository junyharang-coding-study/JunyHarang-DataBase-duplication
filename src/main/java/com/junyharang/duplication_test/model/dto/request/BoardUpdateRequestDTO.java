package com.junyharang.duplication_test.model.dto.request;

import com.junyharang.duplication_test.model.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateRequestDTO {
    private String title;
    @Lob
    @Column(length = 65535, nullable = false)
    private String content;

    @Builder
    public Board toEntity(String title, String content) {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
