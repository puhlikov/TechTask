package com.github.puhlikov.applicationLibrary.service;

import com.github.puhlikov.applicationLibrary.entity.PrintedProduct;

import java.util.List;

/**
 *  Интерфейс сервиса
 */

public interface PrintedProductService {

    /**
     * Метод получения списка всей печатной продукции из БД
     */
    public List<PrintedProduct> getAllPrintedProducts();

    /**
     * Метод сохранения печатной продукции в БД
     * @param printedProduct
     */
    public void savePrintedProduct(PrintedProduct printedProduct);

    /**
     * Метод получения определенной печатной продукции из БД по его id
     * @param id
     */
    public PrintedProduct getPrintedProductById(int id);

    /**
     * Метод получения списка продукции по названию печатной продукции из БД
     * @param title
     */
    public List<PrintedProduct> getPrintedProductByTitle(String title);

    /**
     * Метод получения списка продукции по автору печатной продукции из БД
     * @param author
     */
    public List<PrintedProduct> getPrintedProductByAuthor(String author);

    /**
     * Метод получения списка продукции по типу печатной продукции из БД
     * @param typeOfPrintedProduct
     */
    public List<PrintedProduct> getPrintedProductByType(String typeOfPrintedProduct);

    /**
     * Метод удаления определенной печатной продукции из БД по его id
     * @param id
     */
    public void deletePrintedProductById(int id);
}
