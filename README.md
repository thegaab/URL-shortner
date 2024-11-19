# URL Shortener
Um encurtador de URLs desenvolvido em Java, com integração à AWS para uma solução robusta e escalável.

## 🚀 Funcionalidades
**Encurtar URLs:** Transforme URLs longas em links curtos e fáceis de compartilhar.
**Gerenciamento de URLs:** Salve e gerencie URLs encurtadas.

## <img src="https://m.media-amazon.com/images/I/41d17Q83jSL.png" alt="AWS Logo" width="40" height="40" style="vertical-align:middle"> Integração com AWS:
**AWS Lambda:** Para executar funções de forma escalável e sob demanda.
**Amazon S3:** Para armazenar metadados ou arquivos relacionados ao serviço.

## 🛠️ Tecnologias Utilizadas
**Java:** Linguagem principal do projeto.
**AWS Lambda:** Execução de funções sem servidor.
**Amazon S3:** Armazenamento de dados.
**Maven:** Gerenciamento de dependências e build.

## 🚧 Como Executar
**Pré-requisitos**
- Java 17 ou superior.
- Maven instalado.
- Conta e credenciais AWS configuradas localmente.
 
## Passos
1- Clone o repositório:

```bash
git clone https://github.com/thegaab/URL-shortner.git
cd url-shortner
```

2- Configure as credenciais AWS (em ~/.aws/credentials ou use variáveis de ambiente).

3- Compile o projeto:

```bash
mvn clean install
```
Execute a aplicação:

```bash
mvn spring-boot:run
```

## Acesse a aplicação:

**URL Base:** disponibilzada no painel da AWS

## 🌐 Endpoints Principais
**POST /shorten:** Encurta uma URL.
## Exemplo de corpo:
```json
{
  "originalUrl": "https://exemplo.com"
}
```
**GET /{shortCode}:** Redireciona para a URL original.
## 📦 Deploy na AWS
**Lambda**
- Compile a aplicação como um pacote JAR:
```bash
mvn clean package
```
- Faça o upload do JAR para a AWS Lambda.
**S3**
- Configure um bucket no S3 para armazenar metadados.
- Atualize as permissões e configure o bucket no application.yml.
- 
## 📜 Licença
Este projeto está licenciado sob a MIT License.

