package br.com.bootcamp.itau.systemreview.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @EmbeddedId
    private CommentPK id = new CommentPK();

    private String description;

    private Integer reactionLike;

    private Integer reactionDislike;

    private Boolean repeated;

    private String response;
}