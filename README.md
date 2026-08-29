# Java Obrigações Financeiras

Aplicação desenvolvida em Java para representar empresas e suas obrigações financeiras, aplicando regras de negócio, encapsulamento e tratamento de exceções.

O projeto foi construído com foco em consolidar fundamentos de Java e Programação Orientada a Objetos através de um problema próximo de um cenário real.

---

## Objetivo

O objetivo principal deste projeto foi praticar e consolidar conceitos fundamentais de Java através da implementação de regras de negócio.

Durante o desenvolvimento, a aplicação foi sendo refatorada para impedir a criação de objetos em estados inválidos e garantir que as próprias entidades fossem responsáveis por proteger seus dados e comportamentos.

---

## Funcionalidades

A aplicação permite:

- Criar empresas;
- Criar obrigações financeiras associadas a empresas;
- Registrar o pagamento de uma obrigação;
- Impedir pagamentos com valores inválidos;
- Impedir pagamentos insuficientes;
- Impedir que uma obrigação seja paga mais de uma vez;
- Controlar o status da obrigação entre `PENDENTE` e `PAGA`.

---

## Regras de negócio

### Empresa

Uma empresa deve possuir:

- CNPJ informado;
- Razão social informada.

CNPJ e razão social não podem ser:

- `null`;
- Strings vazias;
- Strings contendo apenas espaços.

### Obrigação

Uma obrigação deve possuir:

- uma empresa associada;
- uma descrição válida;
- um valor maior que zero.

Toda obrigação é criada automaticamente com o status `PENDENTE`.

O status inicial não pode ser definido externamente.

### Pagamento

Para realizar um pagamento:

- o valor deve ser maior que zero;
- o valor informado deve ser igual ou superior ao valor da obrigação;
- uma obrigação já paga não pode ser paga novamente.

Quando todas as regras são atendidas, o status da obrigação é alterado de `PENDENTE` para `PAGA`.

---

## Tratamento de exceções

O projeto utiliza exceções para representar violações das regras de negócio.

Foram criadas exceções customizadas que estendem `RuntimeException`:

- `ValorInvalidoException`
- `PagamentoInsuficienteException`
- `OperacaoJaPaga`

As entidades são responsáveis por detectar situações inválidas e lançar as exceções.

O código que utiliza essas entidades, atualmente representado pela classe `Main`, utiliza `try/catch` para capturar as exceções e decidir como tratar cada erro.

---

## Estrutura do projeto

```text
src/
├── Empresa.java
├── Obrigacao.java
├── StatusObrigacao.java
├── Main.java
└── Exceptions/
    ├── ValorInvalidoException.java
    ├── PagamentoInsuficienteException.java
    └── OperacaoJaPaga.java
```

---

## Principais conceitos praticados

- Classes e objetos;
- Atributos;
- Construtores;
- Encapsulamento;
- Modificadores de acesso;
- Uso de `this`;
- Métodos;
- Parâmetros;
- `enum`;
- Regras de negócio;
- Validação no construtor;
- Proteção do estado dos objetos;
- Exceções customizadas;
- `RuntimeException`;
- `throw`;
- `try/catch`;
- `getMessage()`;
- `null`;
- `isBlank()`;
- Operadores condicionais;
- Separação de responsabilidades entre classes.

---

## Decisões de modelagem

### Status controlado pela própria obrigação

O status não é recebido no construtor.

Toda nova obrigação nasce como `PENDENTE`, evitando que código externo consiga criar uma obrigação diretamente como `PAGA`.

### Validação durante a criação dos objetos

Os construtores verificam dados obrigatórios para impedir que objetos sejam criados em estados inválidos.

### Regra de pagamento dentro de `Obrigacao`

A própria classe `Obrigacao` possui conhecimento suficiente para determinar se um pagamento pode ou não ser realizado.

Por isso, as regras de pagamento permanecem dentro dessa entidade.

### Tratamento fora da entidade

A classe `Obrigacao` detecta e lança as exceções.

Quem chama o método de pagamento decide como tratar o problema através de `try/catch`.

Essa separação evita que a entidade fique responsável por operações de apresentação, como imprimir mensagens no console.

---

## Cenários testados

### Pagamento insuficiente

```text
Obrigação: R$ 110
Pagamento: R$ 80

Resultado: PagamentoInsuficienteException
```

### Valor de pagamento inválido

```text
Pagamento: R$ -20

Resultado: ValorInvalidoException
```

### Pagamento válido

```text
Obrigação: R$ 200
Pagamento: R$ 200

Resultado:
PENDENTE -> PAGA
```

### Tentativa de pagamento duplicado

```text
Primeiro pagamento:
PENDENTE -> PAGA

Segundo pagamento:
OperacaoJaPaga
```

---

## Tecnologias utilizadas

- Java
- Git
- GitHub
- IntelliJ IDEA

---

## Como executar

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

Entre no diretório do projeto:

```bash
cd java-obrigacoes-financeiras
```

Abra o projeto em uma IDE com suporte a Java e execute a classe `Main`.

---

## Escopo atual

Esta é a primeira versão do projeto.

O escopo atual foi propositalmente mantido simples para priorizar fundamentos de Java, POO e regras de negócio.

Nesta versão não foram utilizados:

- Banco de dados;
- Spring;
- API REST;
- Collections;
- Frontend;
- Frameworks externos.

Esses recursos poderão ser adicionados futuramente conforme a evolução dos estudos.

---

## Aprendizados

O projeto começou como um exercício para revisão de fundamentos, mas durante sua implementação alguns pontos se tornaram especialmente importantes:

- diferença entre parâmetro, atributo e variável local;
- responsabilidade do construtor;
- proteção dos invariantes de um objeto;
- diferença entre lançar e tratar uma exceção;
- uso de `throw` para interromper operações inválidas;
- uso de `try/catch` no código chamador;
- diferença entre o valor da obrigação e o valor recebido como pagamento;
- controle do estado interno de um objeto;
- importância de evitar que regras de negócio dependam apenas de mensagens impressas;
- validação de `null`, Strings vazias e Strings em branco.

---

## Status do projeto

**MVP concluído.**
