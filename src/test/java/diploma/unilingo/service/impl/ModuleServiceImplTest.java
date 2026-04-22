package diploma.unilingo.service.impl;

import diploma.unilingo.entity.Module;
import diploma.unilingo.repository.CourseRepository;
import diploma.unilingo.repository.ModuleRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModuleServiceImplTest {

    @Mock
    private ModuleRepository moduleRepository;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private UserSubSkillRepository userSubSkillRepository;

    @InjectMocks
    private ModuleServiceImpl moduleService;

    @Test
    void shouldReturnModule() {

        diploma.unilingo.entity.Module module = new diploma.unilingo.entity.Module();
        module.setId(1L);

        when(moduleRepository.findById(1L))
                .thenReturn(Optional.of(module));

        Module result = moduleService.getModule(1L);

        assertEquals(1L, result.getId());
    }
}