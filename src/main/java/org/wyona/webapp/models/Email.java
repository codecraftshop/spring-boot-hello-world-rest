package org.wyona.webapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Email implements Serializable {

    private String email;
    private String subject;
    private String text;
    @JsonIgnore
    private MultipartFile attachment;

    // INFO: Default constructor is necessary, because otherwise a 400 is generated when using @RequestBody (see https://stackoverflow.com/questions/27006158/error-400-spring-json-requestbody-when-doing-post)
    public Email() {
    }

    /**
     *
     */
    public Email(String email, String subject, String text) {
        this.email = email;
        this.subject = subject;
        this.text = text;
    }

    // using builder pattern to avoid overloading the constructor, or changing the existing one
    public Email attachment(MultipartFile attachment) {
        // TODO: 17.12.2019 validate attachment type before setting ??
        this.attachment = attachment;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }
}
