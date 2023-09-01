package jjfactory.common.feedback.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sendUserId;
    private Long receiveUserId;

    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type{

    }

    @Builder
    public Feedback(Long sendUserId, Long receiveUserId, String content, Type type) {
        this.sendUserId = sendUserId;
        this.receiveUserId = receiveUserId;
        this.content = content;
        this.type = type;
    }

    public void update(String content, Type type){
        if(StringUtils.hasText(content)) this.content = content;
        this.type = type;
    }
}
