package ru.andreykatunin.model.photo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Base64;

@Entity
@ApiModel(description = "Модель данных фотографий")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="object_type_id", discriminatorType = DiscriminatorType.INTEGER)
public class Photo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Идентификатор записи БД")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @Column(name = "data")
    private byte[] data;

    @Transient
    private String url;

    @Column(name = "type")
    private Integer type;

    public Photo() {
    }

    public Photo(byte[] data) {
        this.data = data;
    }

    public Photo(String name, String status, byte[] data) {
        this.name = name;
        this.status = status;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setData(String content) {
        this.data = Base64.getDecoder().decode(content);
    }

    public byte[] getData() {
        return data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
