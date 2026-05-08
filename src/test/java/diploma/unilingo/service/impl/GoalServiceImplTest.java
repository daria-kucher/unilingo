package diploma.unilingo.service.impl;

import diploma.unilingo.dto.GoalDTO;
import diploma.unilingo.entity.Goal;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.exception.goal.GoalNotFoundException;
import diploma.unilingo.mapper.GoalMapper;
import diploma.unilingo.repository.GoalRepository;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GoalServiceImplTest {

    @Mock
    private GoalRepository goalRepository;

    @Mock
    private GoalMapper goalMapper;

    @InjectMocks
    private GoalServiceImpl goalService;

    @Test
    @DisplayName("Should successfully create a goal")
    void createGoal_Success() {
        GoalDTO requestDto = new GoalDTO();
        Goal entity = new Goal();
        GoalDTO responseDto = new GoalDTO();

        when(goalMapper.toEntity(requestDto)).thenReturn(entity);
        when(goalRepository.save(entity)).thenReturn(entity);
        when(goalMapper.toDto(entity)).thenReturn(responseDto);

        GoalDTO result = goalService.createGoal(requestDto);

        assertNotNull(result);
        verify(goalMapper).toEntity(requestDto);
        verify(goalRepository).save(entity);
        verify(goalMapper).toDto(entity);
    }

    @Test
    void getGoal_Found() {
        Long goalId = 1L;
        Goal entity = new Goal();
        GoalDTO responseDto = new GoalDTO();

        when(goalRepository.findById(goalId)).thenReturn(Optional.of(entity));
        when(goalMapper.toDto(entity)).thenReturn(responseDto);

        GoalDTO result = goalService.getGoal(goalId);

        assertEquals(responseDto, result);
        verify(goalRepository).findById(goalId);
    }

    @Test
    @DisplayName("Should throw GoalNotFoundException when goal does not exist")
    void getGoal_NotFound_ThrowsException() {
        Long goalId = 99L;
        when(goalRepository.findById(goalId)).thenReturn(Optional.empty());

        assertThrows(GoalNotFoundException.class, () -> goalService.getGoal(goalId));
        verify(goalRepository).findById(goalId);
        verifyNoInteractions(goalMapper);
    }
}