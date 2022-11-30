package com.junyharang.duplication_test.service;

import com.junyharang.duplication_test.common.constant.DefaultResponse;
import com.junyharang.duplication_test.model.dto.request.BoardRequestDTO;
import com.junyharang.duplication_test.model.dto.request.BoardUpdateRequestDTO;
import com.junyharang.duplication_test.model.dto.response.BoardResponseDTO;
import com.junyharang.duplication_test.model.entity.Board;

import java.util.List;

public interface JunyHarangTestService {

    DefaultResponse<List<Board>> getBoardList();

    DefaultResponse<BoardResponseDTO> getBoard(Long id);

    DefaultResponse<Long> insertBoard(BoardRequestDTO boardRequestDTO);

    DefaultResponse<Long> updateBoard(Long id, BoardUpdateRequestDTO boardUpdateRequestDTO);

    DefaultResponse<Long> deleteBoard(Long id);
}
