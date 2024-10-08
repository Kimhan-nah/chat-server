package com.anchoreer.chat.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "chat_room_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomUser extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @NotNull
    private Boolean isDeleted;

    @Builder
    public ChatRoomUser(Long id, User user, ChatRoom chatRoom, Boolean isDeleted) {
        this.id = id;
        this.user = user;
        this.chatRoom = chatRoom;
        this.isDeleted = isDeleted;
    }

    public void delete() {
        this.isDeleted = true;
    }
}
