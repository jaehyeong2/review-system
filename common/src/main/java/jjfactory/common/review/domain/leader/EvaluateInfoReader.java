package jjfactory.common.review.domain.leader;

import java.util.List;

public interface EvaluateInfoReader {
    EvaluateInfo getOrThrow(Long id);
    EvaluateInfo getOrNull(Long id);
    List<EvaluateInfo> getByMetaId(Long metaId);
    List<EvaluateInfo> getByEvaluatorId(Long evaluatorId);
    List<EvaluateInfo> getByEvaluatorIdAndMetaId(Long evaluatorId, Long metaId);

}
