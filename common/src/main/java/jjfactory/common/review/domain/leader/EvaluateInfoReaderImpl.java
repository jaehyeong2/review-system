package jjfactory.common.review.domain.leader;

import jjfactory.common.global.exception.ResourceNotFoundException;
import jjfactory.common.review.infra.leader.EvaluateInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EvaluateInfoReaderImpl implements EvaluateInfoReader {
    private final EvaluateInfoRepository evaluateInfoRepository;
    @Override
    public EvaluateInfo getOrThrow(Long id) {
        return evaluateInfoRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("evaluation info not found");
        });
    }

    @Override
    public EvaluateInfo getOrNull(Long id) {
        return evaluateInfoRepository.findById(id).orElse(null);
    }

    @Override
    public List<EvaluateInfo> getByMetaId(Long metaId) {
        return evaluateInfoRepository.findAllByMetaId(metaId);
    }

    @Override
    public List<EvaluateInfo> getByEvaluatorId(Long evaluatorId) {
        return evaluateInfoRepository.findAllByEvaluatorId(evaluatorId);
    }

    @Override
    public List<EvaluateInfo> getByEvaluatorIdAndMetaId(Long evaluatorId, Long metaId) {
        return evaluateInfoRepository.findAllByEvaluatorIdAAndMetaId(evaluatorId, metaId);
    }
}
