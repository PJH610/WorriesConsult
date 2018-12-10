package com.worriesconsult.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by SX-503 on 2018/12/10.
 */
@JsonIgnoreProperties(value = {"handler"})
public class Content {
    private Long id;
    private String message;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
