package ru.forevajun.sample.back.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "surname", "phoneNumber"})
public class PersonDto implements Serializable {
    private static final long serialVersionUID = -8259531615458875165L;

    @JsonProperty("id")
    @JsonPropertyDescription("ID клиента")
    private Long id;

    @JsonProperty("name")
    @JsonPropertyDescription("Имя клиента")
    private String name;

    @JsonProperty("surname")
    @JsonPropertyDescription("Фамилия клиента")
    private String surname;

    @JsonProperty("phoneNumber")
    @JsonPropertyDescription("Номер телефона клиента")
    private String phoneNumber;

    public PersonDto() {
    }

    public PersonDto(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
