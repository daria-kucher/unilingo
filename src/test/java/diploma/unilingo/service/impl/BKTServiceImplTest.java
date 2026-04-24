package diploma.unilingo.service.impl;

import diploma.unilingo.service.BKTService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BKTServiceImplTest {

    private final BKTService bktService = new BKTServiceImpl();

    @Test
    void shouldIncreaseKnowledgeWhenCorrect() {

        double result = bktService.updateKnowledge(0.2, true, 1.0);

        assertTrue(result > 0.2);
    }

    @Test
    void shouldDecreaseOrSlightlyChangeWhenWrong() {

        double result = bktService.updateKnowledge(0.8, false, 1.0);

        assertTrue(result < 0.8);
    }

    @Test
    void shouldRespectWeight() {

        double lowWeight = bktService.updateKnowledge(0.2, true, 0.5);
        double highWeight = bktService.updateKnowledge(0.2, true, 1.5);

        assertTrue(highWeight > lowWeight);
    }

    @Test
    void shouldStayWithinBounds() {

        double result = bktService.updateKnowledge(0.99, true, 2.0);

        assertTrue(result <= 1.0);
        assertTrue(result >= 0.0);
    }
}