package jjfactory.common.review.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ReviewType{
    SELF("본인 성과 리뷰"),
    PEER("동료 리뷰"),
    LEADERSHIP("리더 리뷰"),
    PERFORMANCE("성과 리뷰");
    private String description;
}
