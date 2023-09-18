package jjfactory.admin.period.review_meta.presentation;

import jjfactory.admin.period.review_meta.application.ReviewMetaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class ReviewMetaController {
    private final ReviewMetaFacade reviewMetaFacade;
}
