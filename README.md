Aqui está um exemplo de arquivo README.md que você pode usar para instruir como construir e executar sua aplicação Spring Boot em Docker:

```markdown
# Construção e Execução da Aplicação Spring Boot em Docker

Este repositório contém uma aplicação Spring Boot em Kotlin e um Dockerfile para construir uma imagem Docker e executar a aplicação dentro de um contêiner Docker.

## Pré-requisitos

- Docker instalado e configurado no seu sistema: [Instalação do Docker](https://docs.docker.com/get-docker/)
- JDK (Java Development Kit) instalado no seu sistema

## Como Construir a Imagem Docker

1. Clone este repositório para o seu sistema local:

   ```bash
   git clone <url-do-repositorio>
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd nome-do-diretorio-do-projeto
   ```

3. Gere o arquivo JAR da aplicação Spring Boot usando o Gradle:

   ```bash
   ./gradlew build
   ```

4. Construa a imagem Docker usando o Dockerfile:

   ```bash
   sudo docker build --file Dockerfile --build-arg JAR_FILE=build/libs/jwt-0.0.1-SNAPSHOT.jar -t jwt .
   ```

## Como Executar a Aplicação em Docker

Após a construção da imagem Docker, você pode executar a aplicação dentro de um contêiner Docker usando o seguinte comando:

```bash
sudo docker run -d -p 8080:8080 --name jwt jwt
```

Isso iniciará o contêiner Docker em segundo plano (`-d`), mapeando a porta 8080 do contêiner para a porta 8080 do host (`-p 8080:8080`) e nomeando o contêiner como `jwt` (`--name jwt`).

Para acessar a aplicação, basta abrir um navegador da web e navegar até http://localhost:8080.

```

Você pode ajustar as instruções e comandos conforme necessário para se adequarem à sua aplicação e ao seu ambiente específico. Certifique-se de substituir `<url-do-repositorio>` e `nome-do-diretorio-do-projeto` pelos valores reais do seu repositório e diretório do projeto.