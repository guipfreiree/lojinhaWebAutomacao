package modulos.produtos;

import Paginas.AdicionarProdutoPage;
import Paginas.ListagemProdutosPage;
import Paginas.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@DisplayName("Testes Web do Módulo de Produtos")
public class ProdutoTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver_mac64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        this.navegador = new ChromeDriver(options);

        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Não é permitido adicionar um Produto com valor igual a zero.")
    public void testNaoPermissaoDeProdutoComValorIgualZero(){
        String mensagemDeErroApresentada = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterLogin()
                .clicarBotaoAdicionarProdutos()
                .informarNomeProduto("Super nitendo")
                .informarValorProduto("000")
                .informarCores("amarelo e preto")
                .clicarParaCadastrarProdutoComErro()
                .mensagemDeErroParaValorDeProduto();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemDeErroApresentada);
        }

    @Test
    @DisplayName("Não é permitido adicionar um Produto com valor maior do que R$ 7.000,00")
    public void testNaoPermissaoDeProdutoComValorMaiorDoQue7mil() {
        String mensagemDeErroApresentada = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterLogin()
                .clicarBotaoAdicionarProdutos()
                .informarNomeProduto("Super nitendo")
                .informarValorProduto("700001")
                .informarCores("amarelo e preto")
                .clicarParaCadastrarProdutoComErro()
                .mensagemDeErroParaValorDeProduto();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemDeErroApresentada);
    }

    @Test
    @DisplayName("Adicionar um Produto com valor válido maior do que R$ 0,00 e menor do que R$ 7.000,01")
    public void testAdicicaoDeProdutoComValorValido() {
        String mensagemDeSucessoApresentada = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterLogin()
                .clicarBotaoAdicionarProdutos()
                .informarNomeProduto("Super nitendo")
                .informarValorProduto("70000")
                .informarCores("amarelo e preto")
                .clicarParaCadastrarProdutoComSucesso()
                .mensagemDeSucessoParaValorDeProduto();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemDeSucessoApresentada);
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }

}
