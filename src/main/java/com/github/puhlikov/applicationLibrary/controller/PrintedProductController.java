package com.github.puhlikov.applicationLibrary.controller;

import com.github.puhlikov.applicationLibrary.entity.PrintedProduct;
import com.github.puhlikov.applicationLibrary.service.PrintedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер - предназначен для обработки запросов от клиента и возвращению результатов запроса.
 * Аннотация @RestController - представление запросов в виде JSON.
 * Аннотация @RequestMapping - аннотация, предназначенная задать методам контроллера адреса, по которым они будут доступны на клиенте.
 * Использовалась программа POSTMAN - проверяет работу API генерируя запросы.
 */

@RestController
@RequestMapping("/application")
public class PrintedProductController {

    /**
     * Инжектим бин сервиса.
     */
    @Autowired
    private PrintedProductService printedProductService;

    /**
     * Запрос GET на вывод всей печатной продукции,
     * адрес - http://localhost:9002/application/printedProducts
     * @return возвращает всю печатную продукцию в БД
     */
    @GetMapping("/printedProducts")
    public List<PrintedProduct> getAllPrintedProducts() {
        List<PrintedProduct> allPrintedProducts = printedProductService.getAllPrintedProducts();
        return allPrintedProducts;
    }

    /**
     * Запрос GET на вывод печатной продукции по id,
     * адрес - http://localhost:9002/application/printedProducts/{id}
     * @return возвращает одну печатную продукцию из БД, согласно id
     */
    @GetMapping("/printedProducts/{id}")
    public PrintedProduct getPrintedProductById(@PathVariable int id) {
        PrintedProduct printedProduct = printedProductService.getPrintedProductById(id);
        return printedProduct;
    }

    /**
     * Запрос POST на сохранение новой продукции в БД,
     * адрес - http://localhost:9002/application//printedProducts
     * @param printedProduct
     * @return возвращает всю печатную продукцию в БД + новый объект
     */
    @PostMapping("/printedProducts")
    public PrintedProduct addNewPrintedProduct(@RequestBody PrintedProduct printedProduct) {
        printedProductService.savePrintedProduct(printedProduct);
        return printedProduct;
    }

    /**
     * Запрос PUT на изменение данных продукции в БД,
     * адрес - http://localhost:9002/application//printedProducts
     * @param printedProduct
     * @return возвращает всю печатную продукцию в БД
     */
    @PutMapping("/printedProducts")
    public PrintedProduct updatePrintedProduct(@RequestBody PrintedProduct printedProduct) {
        printedProductService.savePrintedProduct(printedProduct);
        return printedProduct;
    }

    /**
     * Запрос DELETE на удаление печатной продукции по id,
     * адрес - http://localhost:9002/application/printedProducts/{id}
     */
    @DeleteMapping("/printedProducts/{id}")
    public String deletePrintedProductById(@PathVariable int id) {
        printedProductService.deletePrintedProductById(id);
        return "PrintedProduct with ID = " + id + " was deleted";
    }

    /**
     * Запрос GET на вывод печатной продукции, соответствующей названию
     * адрес - http://localhost:9002/application/printedProducts/title/{title}
     * @param title
     * @return возвращает печатную продукцию в БД по названию
     */
    @GetMapping("/printedProducts/title/{title}")
    public List<PrintedProduct> getPrintedProductByTitle(@PathVariable String title) {
        List<PrintedProduct> printedProducts = printedProductService.getPrintedProductByTitle(title);
        return printedProducts;
    }

    /**
     * Запрос GET на вывод печатной продукции, соответствующей автору
     * адрес - http://localhost:9002/application/printedProducts/author/{author}
     * @param author
     * @return возвращает печатную продукцию в БД, принадлежащему автору
     */
    @GetMapping("/printedProducts/author/{author}")
    public List<PrintedProduct> getPrintedProductByAuthor(@PathVariable String author) {
        List<PrintedProduct> printedProducts = printedProductService.getPrintedProductByAuthor(author);
        return printedProducts;
    }

    /**
     * Запрос GET на вывод печатной продукции, соответствующей автору
     * адрес - http://localhost:9002/application/printedProducts/typeOfPrintedProduct/{typeOfPrintedProduct}
     * @param typeOfPrintedProduct
     * @return возвращает печатную продукцию в БД, принадлежащему определенного типа
     */
    @GetMapping("/printedProducts/typeOfPrintedProduct/{typeOfPrintedProduct}")
    public List<PrintedProduct> getPrintedProductByType(@PathVariable String typeOfPrintedProduct){
        List<PrintedProduct> printedProducts = printedProductService.getPrintedProductByType(typeOfPrintedProduct);
        return printedProducts;
    }
}
