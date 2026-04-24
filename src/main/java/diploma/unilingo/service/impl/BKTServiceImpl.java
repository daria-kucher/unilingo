package diploma.unilingo.service.impl;

import diploma.unilingo.service.BKTService;
import org.springframework.stereotype.Service;

@Service
public class BKTServiceImpl implements BKTService {
    // базові параметри
    private static final double P_T = 0.1; // learning
    private static final double P_G = 0.2; // guess
    private static final double P_S = 0.1; // slip

    @Override
    public double updateKnowledge(double prior, boolean correct, double weight) {

        double posterior;

        if (correct) {
            posterior = (prior * (1 - P_S)) /
                    (prior * (1 - P_S) + (1 - prior) * P_G);
        } else {
            posterior = (prior * P_S) /
                    (prior * P_S + (1 - prior) * (1 - P_G));
        }

        // врахування ваги піднавички
        double learningRate = P_T * weight;

        double updated = posterior + (1 - posterior) * learningRate;

        // обмеження [0,1]
        return Math.min(1.0, Math.max(0.0, updated));
    }
}
