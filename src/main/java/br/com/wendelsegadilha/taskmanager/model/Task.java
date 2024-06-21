package br.com.wendelsegadilha.taskmanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Task {
    @Id
    private String id;
    @DBRef
    private User user;
    private String title;
    private String description;
    private Boolean completed = Boolean.FALSE;
}
