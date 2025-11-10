# MotusWatch - Sistema de Gestão de Motos

## 📝 Descrição
O **MotusWatch** é um sistema de gestão de motos que utiliza **classificação por cores** para otimizar a organização e o controle das motocicletas dentro do pátio da Mottu.

---

## ⚙️ Funcionalidades

### 🎨 Classificação por Cores
- **Verde**: Pronta para uso (sem limite de tempo)  
- **Amarelo**: Reparos rápidos (limite de 15 minutos)  
- **Vermelho**: Reparos graves (prioridade alta)  
- **Roxo**: Problemas administrativos (até resolução)

### 🧩 Funcionalidades Principais

#### CRUD Completo
- ✅ Cadastro de motocicletas com validações  
- ✅ Listagem de todas as motos  
- ✅ Busca por ID, placa ou categoria  
- ✅ Atualização e exclusão de registros  
- ✅ Categorização por cores  
- ✅ Registro automático de data/hora de entrada  
- ✅ Campo de observações  
- ✅ Suporte a diferentes modelos (Sport, Mottu E, Mottu Pop)

#### Sistema de Alertas e Priorização (Fluxo 1)
- ✅ Monitoramento em tempo real  
- ✅ Alertas automáticos por tempo limite  
- ✅ Níveis de alerta: **NORMAL**, **ATENÇÃO**, **CRÍTICO**  
- ✅ Ordenação por urgência  
- ✅ Regras por categoria:
  - Amarela → Limite de 15 minutos  
  - Vermelha → Prioridade máxima  
  - Roxa → Monitoramento administrativo  
  - Verde → Motos prontas para uso

#### Dashboard e Estatísticas (Fluxo 2)
- ✅ Métricas em tempo real  
- ✅ Distribuição por tipo de moto  
- ✅ Tempo médio no pátio  
- ✅ Status geral do pátio (ÓTIMO, BOM, ATENÇÃO, CRÍTICO)  
- ✅ Contadores de alertas ativos e fora do prazo

#### Validações Implementadas
- ✅ Placa obrigatória (formato ABC1234)  
- ✅ Modelo e categoria obrigatórios  
- ✅ Observações limitadas a 500 caracteres  
- ✅ Validação de URL de imagem  
- ✅ Tratamento de erros descritivo  

---

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.1.6**
- **Spring Data JPA**
- **Spring Web**
- **Oracle Database**
- **Lombok**
- **Maven**
- **SpringDoc OpenAPI**
- **Bean Validation**

---

## 🚀 Deploy em Nuvem
- 🌐 Aplicação disponível: [motuswatchs4webapp.azurewebsites.net](https://motuswatchs4webapp.azurewebsites.net)

---

## 🗄️ Banco de Dados
Banco **Oracle SQL** hospedado em servidor FIAP.  
Configuração realizada para a disciplina **Mastering Relational and Non-Relational Database**.

---

## 🧩 Integração das Disciplinas e Evidências

### **Explicitação e Demonstração de como as Demais Disciplinas foram Aplicadas**

O projeto **Motus Watch** foi desenvolvido de forma interdisciplinar, aplicando os conhecimentos das seguintes disciplinas:

- **MASTERING RELATIONAL AND NON-RELATIONAL DATABASE**  
  Conexão com **Oracle SQL** para armazenamento e gerenciamento de dados.  
  Aplicação de modelagem relacional e scripts SQL garantindo integridade e performance.

- **DEVOPS TOOLS & CLOUD COMPUTING**  
  **Deploy** realizado na **Microsoft Azure**, permitindo acesso público:  
  🔗 [motuswatchs4webapp.azurewebsites.net](https://motuswatchs4webapp.azurewebsites.net)  
  Implementação de **CI/CD** com GitHub.

- **MOBILE APPLICATION DEVELOPMENT**  
  Desenvolvimento da versão **mobile híbrida** com base nos conceitos da disciplina.  
  Demonstração será disponibilizada no YouTube:  
  🎥 *(link do vídeo será inserido aqui)*

---

### **Protótipos e Evidências**
- 🎨 Protótipo no Figma: [Challenge Mottu](https://www.figma.com/design/D4JjlISesUrKATq9rBHYXq/Challenge-Mottu?node-id=0-1&p=f)  
- 📁 Repositório GitHub: [ucarols/Sprint4_java](https://github.com/ucarols/Sprint4_java)  
- 📜 Scripts SQL e estrutura do banco Oracle  
- ☁️ Deploy ativo na Azure  
- 📱 Vídeo demonstrativo da aplicação mobile *(em breve)*  
- 🎥 Vídeo de apresentação *(em breve)*  

---

## 👥 Integrantes
- Caroline de Oliveira — RM 559123  
- Giulia Correa Camillo — RM 554473  
- Lavinia Soo Hyun Park — RM 555679

---

## 📊 Modelos de Dados

### Entidade: Moto
```java
{
  "id": Long,
  "placa": String,
  "modelo": "SPORT" | "MOTTU_E" | "MOTTU_POP",
  "categoria": "VERDE" | "AMARELA" | "VERMELHA" | "ROXA",
  "observacao": String,
  "dataHoraEntrada": LocalDateTime,
  "imagemUrl": String
}
```

### Enums Disponíveis
**Modelos:**
- SPORT → Motocicleta esportiva  
- MOTTU_E → Mottu elétrica  
- MOTTU_POP → Mottu popular  

**Categorias:**
- VERDE → Moto pronta para uso  
- AMARELA → Reparos rápidos  
- VERMELHA → Reparos graves  
- ROXA → Problemas administrativos  

---

## 🧪 Testando a API

### Endpoints de Motos
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
curl -X POST http://localhost:8081/api/motos -H "Content-Type: application/json" -d '{
  "placa": "ABC1234",
  "modelo": "SPORT",
  "categoria": "VERDE",
  "observacao": "Nova moto"
}'

# Atualizar moto
curl -X PUT http://localhost:8081/api/motos/1 -H "Content-Type: application/json" -d '{
  "placa": "ABC1234",
  "modelo": "MOTTU_E",
  "categoria": "AMARELA",
  "observacao": "Moto atualizada"
}'

# Deletar moto
curl -X DELETE http://localhost:8081/api/motos/1
```

### Endpoints de Alertas
```bash
# Listar motos com alertas ativos
curl -X GET http://localhost:8081/api/alertas

# Listar motos fora do prazo
curl -X GET http://localhost:8081/api/alertas/fora-prazo

# Listar motos por prioridade
curl -X GET http://localhost:8081/api/alertas/prioridade
```

### Endpoints de Estatísticas
```bash
# Obter dashboard completo
curl -X GET http://localhost:8081/api/estatisticas
```
