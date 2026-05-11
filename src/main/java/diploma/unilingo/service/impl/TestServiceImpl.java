package diploma.unilingo.service.impl;

import diploma.unilingo.dto.TestDTO;
import diploma.unilingo.exception.test.TestNotFoundException;
import diploma.unilingo.mapper.TestMapper;
import diploma.unilingo.repository.TestRepository;
import diploma.unilingo.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    private final TestMapper testMapper;
    private final TestRepository testRepository;

    public TestServiceImpl(TestMapper testMapper, TestRepository testRepository) {
        this.testMapper = testMapper;
        this.testRepository = testRepository;
    }


    @Override
    public TestDTO getTest(Long id) {
        var test = testRepository.findById(id).orElseThrow(TestNotFoundException::new);

        return testMapper.toDto(test);
    }

    @Override
    public TestDTO createTest(TestDTO dto) {
        var test = testMapper.toEntity(dto);
        testRepository.save(test);

        return testMapper.toDto(test);
    }

    @Override
    public TestDTO updateTest(Long id, TestDTO request) {
        var test = testRepository.findById(id).orElseThrow(TestNotFoundException::new);

        testMapper.update(request, test);
        testRepository.save(test);

        return testMapper.toDto(test);
    }

    @Override
    public void deleteTest(Long id) {
        var test = testRepository.findById(id).orElseThrow(TestNotFoundException::new);

        testRepository.delete(test);
    }
}
