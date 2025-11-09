# MotusWatch - Sistema de Gestão de Motos

## Descrição
O MotusWatch é um sistema de gestão de motos que utiliza classificação por cores para otimizar a organização e controle das motos dentro do pátio da Mottu.

## Funcionalidades

###  Classificação por Cores
- **Verde**: Pronta para uso (sem limite de tempo)
- **Amarelo**: Reparos rápidos (limite de 15 minutos)
- **Vermelho**: Reparos graves (prioridade alta)
- **Roxo**: Problemas administrativos (até resolução)



### Funcionalidades Principais

#### CRUD Completo
- ✅ Cadastro de motocicletas com validações
- ✅ Listagem de todas as motos
- ✅ Busca por ID específico
- ✅ Busca por placa
- ✅ Busca por categoria
- ✅ Atualização de dados
- ✅ Exclusão de registros
- ✅ Categorização por cores (Verde, Amarela, Vermelha, Roxa)
- ✅ Suporte a diferentes modelos (Sport, Mottu E, Mottu Pop)
- ✅ Registro automático de data/hora de entrada
- ✅ Campo para observações

#### Sistema de Alertas e Priorização (Fluxo 1)
- ✅ **Monitoramento em tempo real** - Calcula tempo de permanência no pátio
- ✅ **Alertas automáticos** - Identifica motos que ultrapassaram limites de tempo
- ✅ **Níveis de alerta** - NORMAL, ATENÇÃO, CRÍTICO
- ✅ **Priorização inteligente** - Ordena motos por urgência
- ✅ **Regras por categoria**:
  - Amarela: Limite de 15 minutos para reparos rápidos
  - Vermelha: Prioridade máxima para problemas graves
  - Roxa: Monitoramento de problemas administrativos
  - Verde: Controle de motos prontas para uso

#### Dashboard e Estatísticas (Fluxo 2)
- ✅ **Métricas em tempo real** - Total de motos por categoria
- ✅ **Análise de modelos** - Distribuição por tipo de moto
- ✅ **Indicadores de performance** - Tempo médio no pátio
- ✅ **Status geral do pátio** - ÓTIMO, BOM, ATENÇÃO, CRÍTICO
- ✅ **Contadores de alerta** - Motos com alerta ativo e fora do prazo

#### Validações Implementadas
- ✅ Placa obrigatória no formato ABC1234 (sem traço)
- ✅ Modelo e categoria obrigatórios
- ✅ Observação limitada a 500 caracteres
- ✅ Validação de URL de imagem
- ✅ Tratamento de erros com mensagens descritivas

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Spring Boot 3.1.6** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **Oracle Database** - Banco de dados relacional
- **Lombok** - Redução de código boilerplate
- **Maven** - Gerenciamento de dependências
- **SpringDoc OpenAPI** - Documentação automática da API
- **Bean Validation** - Validação de dados

## 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- Java 17 ou superior
- Maven 3.6+ 
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Instalação e Execução

### 1. Clone o repositório
```bash
https://github.com/ucarols/JavaSprint 
cd JavaSprint
```

### 2. Execute o projeto com Maven
```bash
mvn spring-boot:run
```

### 3. Ou compile e execute o JAR
```bash
mvn clean package
java -jar target/moto-api-0.0.1-SNAPSHOT.jar
```

### 4. Acesse a aplicação
A aplicação estará disponível em: `http://localhost:8081`

## 📡 Endpoints da API

### 🏍️ Motos - `/api/motos`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/` | Lista todas as motocicletas |
| `GET` | `/{id}` | Busca uma motocicleta por ID |
| `GET` | `/placa/{placa}` | Busca uma motocicleta por placa |
| `GET` | `/categoria/{categoria}` | Lista motos por categoria (VERDE, AMARELA, VERMELHA, ROXA) |
| `POST` | `/` | Cadastra uma nova motocicleta |
| `PUT` | `/{id}` | Atualiza uma motocicleta existente |
| `DELETE` | `/{id}` | Remove uma motocicleta |

### 🚨 Alertas - `/api/alertas`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/` | Lista motos com alertas ativos (ATENÇÃO ou CRÍTICO) |
| `GET` | `/fora-prazo` | Lista motos que ultrapassaram o tempo limite |
| `GET` | `/prioridade` | Lista motos ordenadas por prioridade (mais urgentes primeiro) |

### 📊 Estatísticas - `/api/estatisticas`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/` | Retorna dashboard completo com métricas do pátio |

### Exemplo de Requisição POST/PUT
```json
{
  "placa": "ABC1234",
  "modelo": "SPORT",
  "categoria": "VERDE",
  "observacao": "Moto ok",
  "dataHoraEntrada": "2024-01-15T10:30:00"
}
```

### Exemplo de Resposta - Moto
```json
{
  "id": 1,
  "placa": "ABC1234",
  "modelo": "SPORT",
  "categoria": "VERDE",
  "observacao": "Moto em perfeito estado",
  "dataHoraEntrada": "2024-01-15T10:30:00",
  "imagemUrl": null
}
```

### Exemplo de Resposta - Alerta
```json
{
  "id": 2,
  "placa": "XYZ9999",
  "categoria": "AMARELA",
  "dataHoraEntrada": "2025-11-06T13:00:00",
  "minutosNoPateo": 45,
  "minutosAcimaDolimite": 30,
  "nivelAlerta": "CRITICO",
  "mensagem": "URGENTE! Moto ultrapassou em 30 minutos o limite de 15 minutos para reparos rápidos"
}
```

### Exemplo de Resposta - Estatísticas
```json
{
  "totalMotos": 10,
  "motosVerdes": 3,
  "motosAmarelas": 2,
  "motosVermelhas": 3,
  "motosRoxas": 2,
  "motosComAlerta": 5,
  "motosForaDoPrazo": 2,
  "motosPorModelo": {
    "SPORT": 4,
    "MOTTU_E": 3,
    "MOTTU_POP": 3
  },
  "tempoMedioNoPateo": 45.5,
  "statusGeral": "ATENCAO"
}


## 📚 Documentação

A documentação interativa da API está disponível através do Swagger UI:

- **Swagger UI**: `http://localhost:8081/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8081/v3/api-docs`

## 🗄️ Banco de Dados

### Oracle Database
O projeto utiliza Oracle Database. Configuração de conexão:

- **JDBC URL**: `jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl`
- **Username**: `rm559123`
- **Password**: `fiap`
- **Driver**: `oracle.jdbc.OracleDriver`

### Configuração
```properties
# Oracle Database Configuration
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl
spring.datasource.username=rm559123
spring.datasource.password=fiap
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.open-in-view=false
```

### Tabelas Criadas Automaticamente
O Hibernate criará automaticamente as seguintes estruturas no banco Oracle:
- **Tabela**: `TAB_MOTOS` - Armazena os dados das motocicletas
- **Sequence**: `MOTO_SEQ` - Gerador de IDs para a tabela TAB_MOTOS

## 📊 Modelos de Dados

### Moto
```java
{
  "id": Long,              // ID único (gerado automaticamente)
  "placa": String,         // Placa da moto (obrigatório, único)
  "modelo": Modelo,        // SPORT, MOTTU_E, MOTTU_POP
  "categoria": Categoria,  // VERDE, AMARELA, VERMELHA, ROXA
  "observacao": String,    // Observações adicionais (opcional)
  "dataHoraEntrada": LocalDateTime, // Data/hora de entrada
  "imagemUrl": String     // URL da imagem (opcional)
}
```

### Enums Disponíveis

**Modelos:**
- `SPORT` - Motocicleta esportiva
- `MOTTU_E` - Mottu elétrica
- `MOTTU_POP` - Mottu popular

**Categorias:**
- `VERDE` - Categoria verde
- `AMARELA` - Categoria amarela
- `VERMELHA` - Categoria vermelha
- `ROXA` - Categoria roxa

## 🧪 Testando a API

### Usando cURL

#### Endpoints de Motos
```bash
# Listar todas as motos
curl -X GET http://localhost:8081/api/motos

# Buscar moto por ID
curl -X GET http://localhost:8081/api/motos/1

# Buscar moto por placa
curl -X GET http://localhost:8081/api/motos/placa/ABC1234

# Buscar motos por categoria
curl -X GET http://localhost:8081/api/motos/categoria/AMARELA

# Criar nova moto
curl -X POST http://localhost:8081/api/motos \
  -H "Content-Type: application/json" \
  -d '{
    "placa": "ABC1234",
    "modelo": "SPORT",
    "categoria": "VERDE",
    "observacao": "Nova moto"
  }'

# Atualizar moto
curl -X PUT http://localhost:8081/api/motos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "placa": "ABC1234",
    "modelo": "MOTTU_E",
    "categoria": "AMARELA",
    "observacao": "Moto atualizada"
  }'

# Deletar moto
curl -X DELETE http://localhost:8081/api/motos/1
```

#### Endpoints de Alertas
```bash
# Listar motos com alertas ativos
curl -X GET http://localhost:8081/api/alertas

# Listar motos fora do prazo
curl -X GET http://localhost:8081/api/alertas/fora-prazo

# Listar motos por prioridade
curl -X GET http://localhost:8081/api/alertas/prioridade
```

#### Endpoints de Estatísticas
```bash
# Obter dashboard completo
curl -X GET http://localhost:8081/api/estatisticas
```

### Integrantes
- Caroline de Oliveira - RM 559123
- Giulia Correa Camillo - RM 554473
- Lavinia Soo Hyun Park - RM 555679
