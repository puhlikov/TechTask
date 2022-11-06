package com.github.puhlikov.applicationLibrary.service;

import com.github.puhlikov.applicationLibrary.dao.PrintedProductRepository;
import com.github.puhlikov.applicationLibrary.entity.PrintedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * класс PrintedProductServiceIml - реализация методов PrintedProductService
 */

@Service
public class PrintedProductServiceImpl implements PrintedProductService {

    /**
     * Инжектим бин репозитория
     */
    @Autowired
    private PrintedProductRepository printedProductRepository;

    /**
     * Получения списка всей печатной продукции из БД
     */
    @Override
    public List<PrintedProduct> getAllPrintedProducts() {
        return printedProductRepository.findAll();
    }

    /**
     * Сохранение печатной продукции в БД
     */
    @Override
    public void savePrintedProduct(PrintedProduct printedProduct) {
        printedProductRepository.save(printedProduct);
    }

    /**
     * Получение печатной продукции из БД по id, при отсутствии вывод сообщения
     */
    @Override
    public PrintedProduct getPrintedProductById(int id) {
        PrintedProduct printedProduct = null;
        Optional<PrintedProduct> optionalPrintedProduct = printedProductRepository.findById(id);
        if (optionalPrintedProduct.isPresent()) {
            printedProduct = optionalPrintedProduct.get();
        } else {
            System.out.println("Printed product isn't found");
        }
        return printedProduct;
    }

    /**
     * Получение списка печатной продукции по названию
     *
     * @param title
     * @return список печатной продукции, соответствующий указанному названию продукции
     */
    @Override
    public List<PrintedProduct> getPrintedProductByTitle(String title) {
        List<PrintedProduct> printedProducts = printedProductRepository.findPrintedProductsByTitle(title);
        return printedProducts;
    }

    /**
     * Получение списка печатной продукции по автору, с последующей сортировкой по названию продукции в алфавитном порядке
     *
     * @param author
     * @return список печатной продукции данного автора
     */
    @Override
    public List<PrintedProduct> getPrintedProductByAuthor(String author) {
        List<PrintedProduct> printedProducts = printedProductRepository.findPrintedProductsAllByAuthor(author);
        printedProducts = printedProducts.stream().sorted(Comparator.comparing(PrintedProduct::getTitle)).collect(Collectors.toList());
        return printedProducts;
    }

    /**
     * Получение списка печатной продукции по типу, с последующей сортировкой по дате выхода;
     *
     * @param typeOfPrintedProduct
     * @return список печатной продукции данного типа
     */
    @Override
    public List<PrintedProduct> getPrintedProductByType(String typeOfPrintedProduct) {
        List<PrintedProduct> printedProducts = printedProductRepository.findPrintedProductsByTypeOfPrintedProduct(typeOfPrintedProduct);
        printedProducts = printedProducts.stream().sorted(Comparator.comparing(PrintedProduct::getDateOfPublication)).collect(Collectors.toList());
        return printedProducts;
    }

    /**
     * Удаление печатной продукции из БД по id
     */
    @Override
    public void deletePrintedProductById(int id) {
        printedProductRepository.deleteById(id);
    }
}
