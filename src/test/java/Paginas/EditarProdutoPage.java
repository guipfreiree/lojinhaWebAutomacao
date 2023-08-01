package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditarProdutoPage extends BasePage{

    public EditarProdutoPage(WebDriver navegador) {
        super(navegador);
    }

    public String mensagemDeSucessoParaValorDeProduto() {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
