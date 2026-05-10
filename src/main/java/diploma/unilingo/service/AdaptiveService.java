package diploma.unilingo.service;

import diploma.unilingo.entity.Module;

public interface AdaptiveService {

    Module getNextModule(Long userId);
}
