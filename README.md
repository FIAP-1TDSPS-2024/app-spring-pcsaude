# PC SAUDE

> API Java desenvolvida em Spring Boot chamada PCSAUDE, para o aplicativo Smart Desk, aplicação para monitoramento de métricas de ergonomia em ambientes de trabalho com computadores, para que o APP faça cadastro de clientes, coleta de medições pelos sensores e abertura de reclamações.

---

# Sobre o funcionamento da aplicação:

> Essa API fará o cadastro e login dos usuários a partir do APP Smart Desk, o que permitirá aos mesmos acompanharem as medições de métricas de ergonomia, como luminosidade, postura ou temperatura, a partir de seus IoT dispositivos cadastrados, além de abrir reclamações sobre problemas encontrados. A API também receberá as medições enviadas pelos dispositivos IoT conectados aos computadores dos usuários, armazenando esses dados para análise posterior.
> A captura de medições é independente do usuário estar logado. Porém, para a medição ser associada a um usuário, tanto a medição quanto o usuário devem estar vinculados ao mesmo dispositivo IoT.

---

## Vídeo PITCH sobre o projeto

> Acesse o Link abaixo para assistir ao PITCH.

[Vídeo Explicativo no YouTube](https://www.youtube.com/watch?v=wSOUlz6PsAY)

## Vídeo explicativo da solução

> Acesse o Link abaixo para assistir ao vídeo explicativo da solução.

[Vídeo Explicativo no YouTube](https://www.youtube.com/watch?v=wSOUlz6PsAY)

## 👥 Integrantes do Grupo – CATECH

* **RM561144**: Jonas Oliveira - Responsável por Java e banco de dados
* **RM559336**: Wendell Dourado - Responsável por Mobile e Devops
* **RM559622**: Daniel Batista - Responsável por .NET, IoT e QA

---

## Como Executar a Aplicação

1. Clone o repositório:

```bash
git clone https://github.com/FIAP-1TDSPS-2024/rei-dos-piratas.git
```

2. Acesse o diretório do projeto:

```bash
cd rei-dos-piratas/Java/rei-dos-piratas
```

3. Compile a aplicação:

```bash
mvn clean install
```

4. Execute a aplicação:

```bash
mvn spring-boot:run
```

## Coleção POSTMAN

[Link do arquivo JSON da coleção POSTMAN para teste dos END-POINTS](PC-SAUDE.postman_collection.json)

## Tecnologias Utilizadas

* Java 21
* Spring Boot 3.3.4
* Maven
* Banco de dados: H2, ORACLE

## Bibliotecas e dependências (conforme pom.xml)

Dependências principais:
* org.springframework.boot:spring-boot-starter-data-jpa — JPA + Spring Data (persistência)
* org.springframework.boot:spring-boot-starter-web — Spring MVC / REST
* org.springframework.boot:spring-boot-starter-validation — Bean Validation (JSR-380)
* com.oracle.database.jdbc:ojdbc11 (scope: runtime) — Driver JDBC Oracle
* org.projectlombok:lombok (optional) — Reduz boilerplate com anotações

Ferramentas de desenvolvimento / runtime:
* org.springframework.boot:spring-boot-devtools (scope: runtime, optional) — hot reload / dev tools

Dependências de teste:
* org.springframework.boot:spring-boot-starter-test (scope: test) — JUnit, Spring Test, MockMVC, AssertJ, etc.
* com.h2database:h2 (scope: test) — banco em memória para testes

Plugins relevantes configurados no build:
* maven-compiler-plugin — processamento de anotações (Lombok)
* jacoco-maven-plugin — cobertura de testes
* spring-boot-maven-plugin — empacotamento/execução da aplicação

> Observação: versões seguem as definidas pelo Spring Boot parent (3.3.4). O driver Oracle (ojdbc11) é referenciado sem versão explícita no pom (é resolvido em tempo de execução ou via repositório configurado).