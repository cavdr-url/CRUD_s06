package com.sesionclase04.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "didactic_resources")
public class DidacticResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type;
    private String url;
    private Boolean available;
    private String teacherName;

    // Constructor vacío (obligatorio para JPA)
    public DidacticResource() { }

    // Constructor con parámetros
    public DidacticResource(String title, String type, String url, Boolean available, String teacherName) {
        this.title = title;
        this.type = type;
        this.url = url;
        this.available = available;
        this.teacherName = teacherName;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
}