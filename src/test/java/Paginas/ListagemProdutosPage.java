package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListagemProdutosPage {
    private WebDriver navegador;

    public ListagemProdutosPage (WebDriver navegador) {
        this.navegador = navegador;
    }

    public AdicionarProdutoPage clicarBotaoAdicionarProdutos(){
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new AdicionarProdutoPage(navegador);
    }

    public String mensagemDeErroParaValorDeProduto() {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
