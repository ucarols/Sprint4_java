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

- **Java 17**
- **Spring Boot 3.1.6**
- **Spring Data JPA**
- **Spring Web**
- **Oracle Database**
- **Lombok**
- **Maven**
- **SpringDoc OpenAPI**
- **Bean Validation**

## 🚀 Deploy em Nuvem

- 🌐 Aplicação disponível em: [motuswatchs4webapp.azurewebsites.net](https://motuswatchs4webapp.azurewebsites.net)

## 🗄️ Banco de Dados

- Banco Oracle SQL hospedado em servidor FIAP.
- Configuração realizada para a disciplina **Mastering Relational and Non-Relational Database**.

## 🧩 Integração das Disciplinas e Evidências

### **Explicitação e Demonstração de como as Demais Disciplinas foram Aplicadas**

O projeto **Motus Watch** foi desenvolvido de forma interdisciplinar, aplicando os conhecimentos de diversas disciplinas do curso:

- **MASTERING RELATIONAL AND NON-RELATIONAL DATABASE**  
  A aplicação está conectada a um **banco de dados Oracle SQL**, utilizado para o armazenamento e gerenciamento das motocicletas.  
  Foram aplicadas práticas de modelagem relacional e implementação de scripts SQL, garantindo consistência e performance no acesso aos dados.

- **DEVOPS TOOLS & CLOUD COMPUTING**  
  O **deploy da aplicação web** foi realizado em nuvem através da **plataforma Microsoft Azure**, permitindo o acesso público ao sistema.  
  🔗 [motuswatchs4webapp.azurewebsites.net](https://motuswatchs4webapp.azurewebsites.net)  
  Também foram implementadas práticas de **CI/CD (Integração e Entrega Contínuas)** com repositório GitHub.

- **MOBILE APPLICATION DEVELOPMENT**  
  A versão mobile do Motus Watch foi desenvolvida aplicando os conceitos aprendidos em desenvolvimento mobile híbrido.  
  A demonstração será disponibilizada via YouTube:  
  🎥 *(link do vídeo será inserido aqui)*

### **Protótipos e Evidências**
- 🎨 Protótipo no Figma: [https://www.figma.com/design/D4JjlISesUrKATq9rBHYXq/Challenge-Mottu?node-id=0-1&p=f](https://www.figma.com/design/D4JjlISesUrKATq9rBHYXq/Challenge-Mottu?node-id=0-1&p=f)  
- 📁 Repositório GitHub: [https://github.com/ucarols/Sprint4_java](https://github.com/ucarols/Sprint4_java)  
- 📜 Scripts SQL e estrutura do banco Oracle.  
- ☁️ Deploy ativo na Azure.  
- 📱 Vídeo demonstrativo da aplicação mobile []().
- 📱 Video de Apresentação: []()

---

### 👥 Integrantes
- Caroline de Oliveira - RM 559123  
- Giulia Correa Camillo - RM 554473  
- Lavinia Soo Hyun Park - RM 555679
