package diploma.unilingo.service.impl;

import diploma.unilingo.dto.TestDTO;
import diploma.unilingo.exception.test.TestNotFoundException;
import diploma.unilingo.mapper.TestMapper;
import diploma.unilingo.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestServiceImplTest {
    @Mock
    private TestMapper testMapper;

    @Mock
    private TestRepository testRepository;

    @InjectMocks
    private TestServiceImpl testService;

    private diploma.unilingo.entity.Test entity;
    private TestDTO dto;
    private final Long testId = 1L;

    @BeforeEach
    void setUp() {
        entity = new diploma.unilingo.entity.Test();
        dto = new TestDTO();
    }

    @Test
    void getTest_ShouldReturnDto_WhenIdExists() {
        when(testRepository.findById(testId)).thenReturn(Optional.of(entity));
        when(testMapper.toDto(entity)).thenReturn(dto);

        TestDTO result = testService.getTest(testId);

        assertNotNull(result);
        verify(testRepository).findById(testId);
    }

    @Test
    void getTest_ShouldThrowException_WhenIdNotFound() {
        when(testRepository.findById(testId)).thenReturn(Optional.empty());

        assertThrows(TestNotFoundException.class, () -> testService.getTest(testId));
    }

    @Test
    void createTest_ShouldSaveAndReturnDto() {
        when(testMapper.toEntity(dto)).thenReturn(entity);
        when(testMapper.toDto(entity)).thenReturn(dto);

        TestDTO result = testService.createTest(dto);

        verify(testRepository).save(entity);
        assertNotNull(result);
    }

    @Test
    void updateTest_ShouldUpdateAndSave_WhenIdExists() {
        when(testRepository.findById(testId)).thenReturn(Optional.of(entity));
        when(testMapper.toDto(entity)).thenReturn(dto);

        TestDTO result = testService.updateTest(testId, dto);

        verify(testMapper).update(dto, entity);
        verify(testRepository).save(entity);
        assertNotNull(result);
    }

    @Test
    void updateTest_ShouldThrowException_WhenIdNotFound() {
        when(testRepository.findById(testId)).thenReturn(Optional.empty());

        assertThrows(TestNotFoundException.class, () -> testService.updateTest(testId, dto));
        verify(testRepository, never()).save(any());
    }

    @Test
    void deleteTest_ShouldCallDelete_WhenIdExists() {
        when(testRepository.findById(testId)).thenReturn(Optional.of(entity));

        testService.deleteTest(testId);

        verify(testRepository).delete(entity);
    }

    @Test
    void deleteTest_ShouldThrowException_WhenIdNotFound() {
        when(testRepository.findById(testId)).thenReturn(Optional.empty());

        assertThrows(TestNotFoundException.class, () -> testService.deleteTest(testId));
        verify(testRepository, never()).delete(any());
    }
}