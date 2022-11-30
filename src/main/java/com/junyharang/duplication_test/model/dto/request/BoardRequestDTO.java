package com.junyharang.duplication_test.model.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardRequestDTO {
    private Long id;

    private LocalDateTime createDateTime;
    private LocalDateTime modifiedDateTime;

    private String title;
    @Lob
    @Column(length = 65535, nullable = false)
    private String content;

    @Builder
    public BoardRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
