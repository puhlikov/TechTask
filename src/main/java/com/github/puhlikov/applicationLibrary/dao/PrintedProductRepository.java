package com.github.puhlikov.applicationLibrary.dao;

import com.github.puhlikov.applicationLibrary.entity.PrintedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  Интерфейс, обозначенный аннотаций @Repository, обеспечивает управление доступом к источнику данных.
 *  Наследование от JpaRepository предоставляет набор стандартных методов JPA для работы с БД.
 *   @param PrintedProduct (сущность + его id)
 */

@Repository
public interface PrintedProductRepository extends JpaRepository<PrintedProduct, Integer> {

    /**
     * Метод получения списка продукции по названию печатной продукции из БД
     * @param title
     */
    public List<PrintedProduct> findPrintedProductsByTitle(String title);

    /**
     * Метод получения списка продукции по автору печатной продукции из БД
     * @param author
     */
    public List<PrintedProduct> findPrintedProductsAllByAuthor(String author);


    /**
     * Метод получения списка продукции по типу печатной продукции из БД
     * @param typeOfPrintedProduct
     */
    List<PrintedProduct> findPrintedProductsByTypeOfPrintedProduct(String typeOfPrintedProduct);
}
