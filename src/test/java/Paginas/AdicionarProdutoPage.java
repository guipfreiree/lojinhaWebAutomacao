package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdicionarProdutoPage {
    private WebDriver navegador;

    public AdicionarProdutoPage (WebDriver navegador) {
        this.navegador = navegador;
    }

    public AdicionarProdutoPage informarNomeProduto(String nomeProduto) {
        navegador.findElement(By.id("produtonome")).sendKeys(nomeProduto);

        return this;
    }

    public AdicionarProdutoPage informarValorProduto(String valorProduto) {
        navegador.findElement(By.name("produtovalor")).sendKeys(valorProduto);

        return this;
    }

    public AdicionarProdutoPage informarCores (String cores) {
        navegador.findElement(By.id("produtocores")).sendKeys(cores);

        return this;
    }

    public ListagemProdutosPage clicarParaCadastrarProdutoComErro() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListagemProdutosPage(navegador);
    }

    public EditarProdutoPage clicarParaCadastrarProdutoComSucesso() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new EditarProdutoPage(navegador);
    }
}
