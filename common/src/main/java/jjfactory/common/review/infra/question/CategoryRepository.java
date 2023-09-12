package jjfactory.common.review.infra.question;

import jjfactory.common.review.domain.question.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}