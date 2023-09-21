package jjfactory.common.review.infra.leader;

import jjfactory.common.review.domain.leader.EvaluateInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluateInfoRepository extends JpaRepository<EvaluateInfo, Long> {
    List<EvaluateInfo> findAllByMetaId(Long metaId);
    List<EvaluateInfo> findAllByEvaluatorId(Long evaluatorId);
    List<EvaluateInfo> findAllByEvaluatorIdAndMetaId(Long evaluatorId, Long metaId);

}