package diploma.unilingo.service;

import diploma.unilingo.dto.TestDTO;

public interface TestService {
    TestDTO getTest(Long id);
    TestDTO createTest(TestDTO dto);
    TestDTO updateTest(Long id, TestDTO request);
    void deleteTest(Long id);
}
