package com.junyharang.duplication_test.controller;

import com.junyharang.duplication_test.common.constant.DefaultResponse;
import com.junyharang.duplication_test.model.dto.request.BoardRequestDTO;
import com.junyharang.duplication_test.model.dto.response.BoardResponseDTO;
import com.junyharang.duplication_test.model.entity.Board;
import com.junyharang.duplication_test.service.JunyHarangTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class JunyHarangTestController {

    private final JunyHarangTestService junyHarangTestService;

    @PostMapping("/api/board")
    public ResponseEntity<DefaultResponse<Long>> insertBoard(@RequestBody BoardRequestDTO boardRequestDTO) {
        return new ResponseEntity<>(junyHarangTestService.insertBoard(boardRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/api/board")
    public ResponseEntity<DefaultResponse<List<Board>>> getBoardList() {
        return new ResponseEntity<>(junyHarangTestService.getBoardList(), HttpStatus.OK);
    }

    @GetMapping("/api/board/{id}")
    public ResponseEntity<DefaultResponse<BoardResponseDTO>> getBoard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(junyHarangTestService.getBoard(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<DefaultResponse<Long>> deleteBoard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(junyHarangTestService.deleteBoard(id), HttpStatus.OK);
    }
}
