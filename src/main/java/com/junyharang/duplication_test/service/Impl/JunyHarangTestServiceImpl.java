package com.junyharang.duplication_test.service.Impl;

import com.junyharang.duplication_test.common.constant.DefaultResponse;
import com.junyharang.duplication_test.common.constant.DefaultResponseMessage;
import com.junyharang.duplication_test.model.dto.request.BoardRequestDTO;
import com.junyharang.duplication_test.model.dto.request.BoardUpdateRequestDTO;
import com.junyharang.duplication_test.model.dto.response.BoardResponseDTO;
import com.junyharang.duplication_test.model.entity.Board;
import com.junyharang.duplication_test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import com.junyharang.duplication_test.service.JunyHarangTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JunyHarangTestServiceImpl implements JunyHarangTestService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public DefaultResponse<Long> insertBoard(BoardRequestDTO boardRequestDTO) {

        if (boardRequestDTO == null) {
            return DefaultResponse.response(DefaultResponseMessage.BAD_REQUEST,
                                            DefaultResponseMessage.KOREAN_400,
                                            DefaultResponseMessage.ENGLISH_400);
        }

        Board board = Board.builder()
                           .title(boardRequestDTO.getTitle())
                           .content(boardRequestDTO.getContent())
                           .build();

        Long saveId = boardRepository.save(board).getId();

        return DefaultResponse.response(DefaultResponseMessage.CREATE_SUCCESS,
                                        DefaultResponseMessage.KOREAN_201,
                                        DefaultResponseMessage.ENGLISH_201,
                                        saveId);
    }

    @Override
    @Transactional(readOnly = true)
    public DefaultResponse<List<Board>> getBoardList() {
        return DefaultResponse.response(
                DefaultResponseMessage.OK,
                DefaultResponseMessage.KOREAN_200,
                DefaultResponseMessage.ENGLISH_200,
                boardRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public DefaultResponse<BoardResponseDTO> getBoard(Long id) {

        Optional<Board> boardById = findValueByID(id);

        if (boardById.isEmpty()) {
            return DefaultResponse.response(
                    DefaultResponseMessage.NOT_FOUND,
                    DefaultResponseMessage.KOREAN_404,
                    DefaultResponseMessage.ENGLISH_404);
        }

        return DefaultResponse.response(
                DefaultResponseMessage.OK,
                DefaultResponseMessage.KOREAN_200,
                DefaultResponseMessage.ENGLISH_200,

                BoardResponseDTO.builder()
                                .id(boardById.get().getId())
                                .title(boardById.get().getTitle())
                                .content(boardById.get().getContent())
                                .build());
    }

    @Override
    @Transactional
    public DefaultResponse<Long> updateBoard(Long id, BoardUpdateRequestDTO boardUpdateRequestDTO) {
        Optional<Board> boardById = findValueByID(id);

        if (boardById.isEmpty()) {
            return DefaultResponse.response(
                    DefaultResponseMessage.NOT_FOUND,
                    DefaultResponseMessage.KOREAN_404,
                    DefaultResponseMessage.ENGLISH_404);
        }

        Board updateBoard = boardById.get().update(boardUpdateRequestDTO);

        return DefaultResponse.response(
                DefaultResponseMessage.CREATE_SUCCESS,
                DefaultResponseMessage.KOREAN_201,
                DefaultResponseMessage.ENGLISH_201,
                boardRepository.save(updateBoard).getId());

    }

    @Override
    @Transactional
    public DefaultResponse<Long> deleteBoard(Long id) {

        Optional<Board> boardById = findValueByID(id);

        if (boardById.isEmpty()) {
            return DefaultResponse.response(
                    DefaultResponseMessage.NOT_FOUND,
                    DefaultResponseMessage.KOREAN_404,
                    DefaultResponseMessage.ENGLISH_404);
        }

        boardRepository.delete(boardById.get());

        return DefaultResponse.response(
                DefaultResponseMessage.OK,
                DefaultResponseMessage.KOREAN_200,
                DefaultResponseMessage.ENGLISH_200,
                id);
    }

    @Transactional(readOnly = true)
    public Optional<Board> findValueByID(Long id) {
        return boardRepository.findById(id);
    }
}
