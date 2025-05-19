# VibeTrack

**VibeTrack** é uma aplicação web para check-ins emocionais diários em equipe.  
Os usuários podem registrar como estão se sentindo, e a aplicação calcula a média emocional da equipe no dia e exibe em um formato amigável.

## 🚀 Funcionalidades

- Registro de check-in emocional (com nota opcional)
- Cálculo da média emocional diária da equipe
- Visualização do clima atual da equipe (`/team-vibe`)
- Interface com Thymeleaf

## 🛠 Tecnologias

- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Maven

## 📦 Como rodar localmente

1. Clone o projeto:

   ```bash
   git clone https://github.com/vieira-a/vibetrack.git
   cd vibetrack
   ```

2. Banco de dados

**IMPORTANTE**
Para sistemas em produção, **é extremamente recomendável não expor as configurações contendo dados sensíveis como URL, logins e senhas de banco de dados**.

Visto que este sistema é **exlusivamente para fins acadêmicos**, as configurações de banco de dados estão expostas em `src/main/resources/application.properties`.
Para que funcione localmente, basta criar um banco de dados na sua instância do PostgreSQL, e modificar este arquivo conforme sua necessidade.

```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
   spring.datasource.username=usuario_banco
   spring.datasource.password=senha_banco
```

3. Compile o projeto

   ```bash
     ./mvnw clean install
   ```

4. Rode a aplicação

   ```bash
     ./mvnw spring-boot:run
   ```

5. Acesse em

   ```html
   http://localhost:8080/
   ```

## Estrutura do projeto

```bash
  src/
  ├── main/
  │   ├── java/com/vibetrack/app/
  │   │   ├── controller/            # Controladores MVC
  │   │   ├── model/                 # Entidades e enums
  │   │   ├── repository/            # Interfaces JPA
  │   │   └── service/               # Regras de negócio
  │   └── resources/
  │       ├── templates/             # Views Thymeleaf (index.html, success.html, team-vibe.html)
  │       └── application.properties
```

## Exemplo de uso

- Acesse / para fazer um check-in emocional
- Acesse /team-vibe para visualizar a média emocional da equipe naquele dia
