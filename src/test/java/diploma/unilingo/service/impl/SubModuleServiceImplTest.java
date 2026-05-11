package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SubModuleDTO;
import diploma.unilingo.entity.SubModule;
import diploma.unilingo.exception.submodule.SubModuleNotFoundException;
import diploma.unilingo.mapper.SubModuleMapper;
import diploma.unilingo.repository.SubModuleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubModuleServiceImplTest {
    @Mock
    private SubModuleRepository subModuleRepository;

    @Mock
    private SubModuleMapper subModuleMapper;

    @InjectMocks
    private SubModuleServiceImpl subModuleService;

    private SubModule entity;
    private SubModuleDTO dto;
    private final Long subModuleId = 1L;
    private final Long moduleId = 100L;

    @BeforeEach
    void setUp() {
        entity = new SubModule();
        dto = new SubModuleDTO();
    }

    @Test
    void getSubModule_ShouldReturnDto_WhenIdExists() {
        when(subModuleRepository.findById(subModuleId)).thenReturn(Optional.of(entity));
        when(subModuleMapper.toDto(entity)).thenReturn(dto);

        SubModuleDTO result = subModuleService.getSubModule(subModuleId);

        assertNotNull(result);
        verify(subModuleRepository).findById(subModuleId);
    }

    @Test
    void getSubModule_ShouldThrowException_WhenIdNotFound() {
        when(subModuleRepository.findById(subModuleId)).thenReturn(Optional.empty());

        assertThrows(SubModuleNotFoundException.class, () -> subModuleService.getSubModule(subModuleId));
    }


    @Test
    void getSubModulesByModuleId_ShouldReturnList() {
        List<SubModule> entities = List.of(entity, new SubModule());
        when(subModuleRepository.findAllByModuleId(moduleId)).thenReturn(entities);
        when(subModuleMapper.toDto(any(SubModule.class))).thenReturn(new SubModuleDTO());

        List<SubModuleDTO> results = subModuleService.getSubModulesByModuleId(moduleId);

        assertEquals(2, results.size());
        verify(subModuleRepository).findAllByModuleId(moduleId);
        verify(subModuleMapper, times(2)).toDto(any(SubModule.class));
    }


    @Test
    void createSubModule_ShouldSaveAndReturnDto() {
        when(subModuleMapper.toEntity(dto)).thenReturn(entity);
        when(subModuleRepository.save(entity)).thenReturn(entity);
        when(subModuleMapper.toDto(entity)).thenReturn(dto);

        SubModuleDTO result = subModuleService.createSubModule(dto);

        verify(subModuleRepository).save(entity);
        assertNotNull(result);
    }


    @Test
    void updateSubModule_ShouldUpdateAndSave_WhenIdExists() {
        when(subModuleRepository.findById(subModuleId)).thenReturn(Optional.of(entity));
        when(subModuleMapper.toDto(entity)).thenReturn(dto);

        SubModuleDTO result = subModuleService.updateSubModule(subModuleId, dto);

        verify(subModuleMapper).update(dto, entity);
        verify(subModuleRepository).save(entity);
        assertNotNull(result);
    }


    @Test
    void delete_ShouldCallDelete_WhenIdExists() {
        when(subModuleRepository.findById(subModuleId)).thenReturn(Optional.of(entity));

        subModuleService.delete(subModuleId);

        verify(subModuleRepository).delete(entity);
    }

    @Test
    void delete_ShouldThrowException_WhenIdNotFound() {
        when(subModuleRepository.findById(subModuleId)).thenReturn(Optional.empty());

        assertThrows(SubModuleNotFoundException.class, () -> subModuleService.delete(subModuleId));
        verify(subModuleRepository, never()).delete(any());
    }
}