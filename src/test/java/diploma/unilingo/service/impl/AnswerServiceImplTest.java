package diploma.unilingo.service.impl;

import diploma.unilingo.dto.AnswerDTO;
import diploma.unilingo.entity.Answer;
import diploma.unilingo.exception.answer.AnswerNotFoundException;
import diploma.unilingo.exception.answer.DuplicateAnswerException;
import diploma.unilingo.mapper.AnswerMapper;
import diploma.unilingo.repository.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnswerServiceImplTest {

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private AnswerMapper answerMapper;

    @InjectMocks
    private AnswerServiceImpl answerService;

    private Answer answer;
    private AnswerDTO answerDTO;

    @BeforeEach
    void setUp() {
        answer = new Answer();
        answer.setId(1L);

        answerDTO = new AnswerDTO();
        answerDTO.setId(1L);
        answerDTO.setExerciseId(10L);
        answerDTO.setText("Sample Answer");
    }


    @Test
    void getAnswer_ShouldReturnDto_WhenIdExists() {
        when(answerRepository.findById(1L)).thenReturn(Optional.of(answer));
        when(answerMapper.toDto(answer)).thenReturn(answerDTO);

        AnswerDTO result = answerService.getAnswer(1L);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
    }

    @Test
    void getAnswer_ShouldThrowException_WhenIdNotFound() {
        when(answerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> answerService.getAnswer(1L))
                .isInstanceOf(AnswerNotFoundException.class);
    }

    @Test
    void getAllAnswers_ShouldReturnList() {
        List<Answer> answers = List.of(answer);
        when(answerRepository.findByExerciseId(10L)).thenReturn(answers);
        when(answerMapper.toDto(answer)).thenReturn(answerDTO);

        List<AnswerDTO> result = answerService.getAllAnswers(10L);

        assertThat(result).hasSize(1);
        verify(answerRepository).findByExerciseId(10L);
    }

    @Test
    void createAnswer_ShouldSave_WhenDataIsUnique() {
        when(answerRepository.existsByExerciseIdAndText(10L, "Sample Answer")).thenReturn(false);
        when(answerMapper.toEntity(answerDTO)).thenReturn(answer);
        when(answerMapper.toDto(answer)).thenReturn(answerDTO);

        AnswerDTO result = answerService.createAnswer(answerDTO);

        verify(answerRepository).save(answer);
        assertThat(result).isEqualTo(answerDTO);
    }

    @Test
    void createAnswer_ShouldThrowException_WhenDuplicateExists() {
        when(answerRepository.existsByExerciseIdAndText(anyLong(), anyString())).thenReturn(true);

        assertThatThrownBy(() -> answerService.createAnswer(answerDTO))
                .isInstanceOf(DuplicateAnswerException.class);

        verify(answerRepository, never()).save(any());
    }


    @Test
    void updateAnswer_ShouldUpdateAndSave_WhenIdExists() {
        when(answerRepository.findById(1L)).thenReturn(Optional.of(answer));
        when(answerMapper.toDto(answer)).thenReturn(answerDTO);

        AnswerDTO result = answerService.updateAnswer(1L, answerDTO);

        verify(answerMapper).update(answerDTO, answer);
        verify(answerRepository).save(answer);
        assertThat(result).isNotNull();
    }


    @Test
    void deleteAnswer_ShouldCallDelete_WhenIdExists() {
        when(answerRepository.findById(1L)).thenReturn(Optional.of(answer));

        answerService.deleteAnswer(1L);

        verify(answerRepository).delete(answer);
    }

    @Test
    void deleteAnswer_ShouldThrowException_WhenIdNotFound() {
        when(answerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> answerService.deleteAnswer(1L))
                .isInstanceOf(AnswerNotFoundException.class);

        verify(answerRepository, never()).delete(any());
    }
}