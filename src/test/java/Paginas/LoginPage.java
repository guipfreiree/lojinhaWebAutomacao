package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver navegador) {
        super(navegador);
    }

    public LoginPage informarUsuario (String usuario) {
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this;
    }

    public LoginPage informarSenha (String senha) {
        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }

    public ListagemProdutosPage submeterLogin() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListagemProdutosPage(navegador);
    }
}
