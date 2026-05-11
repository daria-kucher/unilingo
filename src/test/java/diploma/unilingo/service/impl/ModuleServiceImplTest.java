package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ModuleDTO;
import diploma.unilingo.entity.Module;
import diploma.unilingo.exception.module.ModuleNotFoundException;
import diploma.unilingo.mapper.ModuleMapper;
import diploma.unilingo.repository.ModuleRepository;
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
class ModuleServiceImplTest {

    @Mock
    private ModuleRepository moduleRepository;

    @Mock
    private ModuleMapper moduleMapper;

    @InjectMocks
    private ModuleServiceImpl moduleService;

    private Module entity;
    private ModuleDTO dto;
    private final Long moduleId = 1L;
    private final Long courseId = 10L;

    @BeforeEach
    void setUp() {
        entity = new Module();
        dto = new ModuleDTO();
    }


    @Test
    void getModule_ShouldReturnDto_WhenIdExists() {
        when(moduleRepository.findById(moduleId)).thenReturn(Optional.of(entity));
        when(moduleMapper.toDto(entity)).thenReturn(dto);

        ModuleDTO result = moduleService.getModule(moduleId);

        assertNotNull(result);
        verify(moduleRepository).findById(moduleId);
    }

    @Test
    void getModule_ShouldThrowException_WhenIdNotFound() {
        when(moduleRepository.findById(moduleId)).thenReturn(Optional.empty());

        assertThrows(ModuleNotFoundException.class, () -> moduleService.getModule(moduleId));
    }


    @Test
    void getAllModulesByCourse_ShouldReturnList() {
        List<Module> entities = List.of(entity, new Module());
        when(moduleRepository.findAllByCourseId(courseId)).thenReturn(entities);
        when(moduleMapper.toDto(any(Module.class))).thenReturn(new ModuleDTO());

        List<ModuleDTO> results = moduleService.getAllModulesByCourse(courseId);

        assertEquals(2, results.size());
        verify(moduleRepository).findAllByCourseId(courseId);
    }


    @Test
    void createModule_ShouldSaveAndReturnDto() {
        when(moduleMapper.toEntity(dto)).thenReturn(entity);
        when(moduleRepository.save(entity)).thenReturn(entity);
        when(moduleMapper.toDto(entity)).thenReturn(dto);

        ModuleDTO result = moduleService.createModule(dto);

        verify(moduleRepository).save(entity);
        assertNotNull(result);
    }


    @Test
    void updateModule_ShouldUpdateAndSave_WhenIdExists() {
        when(moduleRepository.findById(moduleId)).thenReturn(Optional.of(entity));
        when(moduleMapper.toDto(entity)).thenReturn(dto);

        ModuleDTO result = moduleService.updateModule(moduleId, dto);

        verify(moduleMapper).update(dto, entity);
        verify(moduleRepository).save(entity);
        assertNotNull(result);
    }


    @Test
    void deleteModule_ShouldCallDelete_WhenIdExists() {
        when(moduleRepository.findById(moduleId)).thenReturn(Optional.of(entity));

        moduleService.deleteModule(moduleId);

        verify(moduleRepository).delete(entity);
    }

    @Test
    void deleteModule_ShouldThrowException_WhenIdNotFound() {
        when(moduleRepository.findById(moduleId)).thenReturn(Optional.empty());

        assertThrows(ModuleNotFoundException.class, () -> moduleService.deleteModule(moduleId));
        verify(moduleRepository, never()).delete(any());
    }
}