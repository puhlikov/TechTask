package com.github.puhlikov.applicationLibrary.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *  Класс сущности БД
 *  @Data - аннотация плагина lombok, внутри скрыта реализация конструкторов, сеттеров, геттеров, переопределение методов equals и hashcode
 */
@Data
@Entity
@Table(name = "printed_product")
public class PrintedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "type_of_printed_product")
    private String typeOfPrintedProduct;

    @Column(name = "date_of_publication")
    private LocalDate dateOfPublication;

    @Column(name = "publishing_house")
    private String publishingHouse;

    @Column(name = "amount")
    private int amount;
}
