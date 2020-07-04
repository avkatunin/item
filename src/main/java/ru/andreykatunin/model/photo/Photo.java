package ru.andreykatunin.model.photo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
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

    @JsonIgnore
    @Column(name = "data")
    private byte[] data;

    @Transient
    private String link;

    @Column(name = "type")
    private Integer type;

    public Photo() {
    }

    public Photo(byte[] data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
