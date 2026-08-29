# Gerenciador de Obrigações Financeiras 💻

Projeto desenvolvido em Java para praticar Programação Orientada a Objetos, tratamento de exceções e modelagem de regras de negócio.

A aplicação permite representar empresas e suas obrigações financeiras, controlando operações de pagamento e seus respectivos estados.

## 💻 Tecnologias

- Java
- Git
- GitHub
- IntelliJ IDEA

## 📌 Regras de negócio

- Uma empresa deve possuir CNPJ e razão social válidos.
- CNPJ e razão social não podem ser `null`, vazios ou conter apenas espaços.
- Uma obrigação deve possuir empresa associada, descrição válida e valor maior que zero.
- Toda obrigação inicia automaticamente com status `PENDENTE`.
- Pagamentos iguais ou menores que zero são inválidos.
- Pagamentos inferiores ao valor da obrigação não são aceitos.
- Uma obrigação já paga não pode ser paga novamente.
- Um pagamento válido altera o status da obrigação para `PAGA`.

## 📚 Conceitos praticados

Durante o desenvolvimento deste projeto foram utilizados conceitos como:

- Classes e objetos
- Encapsulamento
- Construtores
- Modificadores de acesso
- Uso de `this`
- Enums
- Regras de negócio
- Validação de objetos
- Exceções personalizadas
- `RuntimeException`
- `throw`
- `try/catch`
- `getMessage()`
- Validação de `null`
- Uso de `isBlank()`
- Estruturas condicionais
- Organização de código em pacotes
- Separação de responsabilidades entre classes

## 📁 Estrutura principal

```text
src/
├── Empresa.java
├── Obrigacao.java
├── StatusObrigacao.java
├── Main.java
└── Exceptions/
    ├── OperacaoJaPaga.java
    ├── PagamentoInsuficienteException.java
    └── ValorInvalidoException.java