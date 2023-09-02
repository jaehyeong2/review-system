package jjfactory.common.period.infra.review_meta;

import jjfactory.common.period.domain.review_meta.ReviewMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewMetaRepository extends JpaRepository<ReviewMeta, Long> {
}