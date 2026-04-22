package diploma.unilingo.service.impl;

import diploma.unilingo.entity.Module;
import diploma.unilingo.entity.SubModule;
import diploma.unilingo.repository.ModuleRepository;
import diploma.unilingo.repository.SubModuleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SubModuleServiceImplTest {

    @Mock
    private SubModuleRepository subModuleRepository;

    @Mock
    private ModuleRepository moduleRepository;

    @InjectMocks
    private SubModuleServiceImpl subModuleService;

    @Test
    void shouldReturnSubModulesByModule() {

        diploma.unilingo.entity.Module module = new Module();
        module.setId(1L);

        SubModule subModule = new SubModule();
        subModule.setId(10L);

        when(moduleRepository.findById(1L))
                .thenReturn(Optional.of(module));

        when(subModuleRepository.findByModule(module))
                .thenReturn(List.of(subModule));

        List<SubModule> result =
                subModuleService.getSubModulesByModule(1L);

        assertEquals(1, result.size());
    }
}