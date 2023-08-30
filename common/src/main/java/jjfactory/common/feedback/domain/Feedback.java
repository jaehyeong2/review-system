package jjfactory.common.feedback.domain;

import jakarta.persistence.*;
import jjfactory.common.user.domain.User;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sendUser;
    @ManyToOne(fetch = FetchType.LAZY)
    private User receiveUser;

    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type{

    }
}
