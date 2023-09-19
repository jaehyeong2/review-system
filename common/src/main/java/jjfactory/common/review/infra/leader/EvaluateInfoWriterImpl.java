package jjfactory.common.review.infra.leader;

import jjfactory.common.review.domain.leader.EvaluateInfo;
import jjfactory.common.review.domain.leader.EvaluateInfoWriter;
import jjfactory.common.review.infra.leader.EvaluateInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EvaluateInfoWriterImpl implements EvaluateInfoWriter {
    private final EvaluateInfoRepository evaluateInfoRepository;
    @Override
    public EvaluateInfo write(EvaluateInfo evaluateInfo) {
        return evaluateInfoRepository.save(evaluateInfo);
    }
}
