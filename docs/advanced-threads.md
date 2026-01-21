# Advanced Threads

## **1) Sincronização (Synchronized)**

O primeiro e mais básico problema quando falamos de concorrência é quando várias threads tentam **acessar ou modificar o mesmo recurso** (como uma variável ou objeto) ao mesmo tempo, o que pode causar **inconsistência de dados**. A **sincronização** ajuda a resolver isso.

### Conceitos:

* **Métodos sincronizados**: Usar a palavra-chave `synchronized` para garantir que apenas uma thread por vez acesse um método ou bloco de código.
* **Sincronizar em blocos de código**: Sincronizar apenas a parte crítica do código, não o método inteiro.

**Exemplo**: Um contador compartilhado que precisa ser incrementado de forma segura.

### Tópicos:

* Usando `synchronized` em métodos e blocos
* **Problema**: concorrência em variáveis compartilhadas
* **Solução**: evitar condições de corrida com sincronização

**Próximo passo**: Se você quiser, posso mostrar um exemplo **prático e direto** de como sincronizar uma variável compartilhada entre threads.

## **2) Condições de Corrida (Race Conditions)**

Quando duas ou mais threads tentam acessar e modificar o mesmo dado sem a devida sincronização, pode ocorrer uma **condição de corrida**. Isso ocorre porque as threads **não têm controle sobre a ordem** em que as operações são feitas.

### Conceitos:

* **Exemplo de condição de corrida**: Como dois threads podem acessar e alterar o valor de um contador de forma não segura.
* **Solução**: Usar **sincronização** ou **locks explícitos**.

### Tópicos:

* Como as condições de corrida acontecem
* Como usar sincronização para resolver esse problema
* **Exemplo prático** de incremento de contador com e sem sincronização.

**Próximo passo**: Podemos começar com **um contador simples** e simular uma condição de corrida para observar o problema.

## **3) Deadlocks**

Um **deadlock** ocorre quando duas ou mais threads ficam presas esperando uma pela outra, ou seja, **nenhuma delas pode continuar** porque estão esperando recursos uns dos outros.

### Conceitos:

* **Causa do deadlock**: Acontece quando duas ou mais threads esperam por **locks** em ordem cíclica, causando um impasse.
* **Prevenção**: Como evitar que dois threads fiquem bloqueados esperando um pelo outro.

### Tópicos:

* Como identificar um deadlock
* Como prevenir deadlocks usando **locks ordenados** (adquirindo os locks em uma ordem fixa).
* Usando **`Lock`** (do pacote `java.util.concurrent.locks`) para controle mais refinado.

**Próximo passo**: Eu posso mostrar um exemplo simples com **deadlock** para você ver como isso pode acontecer.

## **4) Visibilidade de Variáveis (volatile)**

Quando você tem várias threads lendo e escrevendo em uma variável compartilhada, pode ocorrer uma situação onde **uma thread não vê a atualização de outra thread** de forma imediata. O **`volatile`** resolve esse problema.

### Conceitos:

* **O que `volatile` faz**: Garante que a variável seja **visível** imediatamente entre threads, sem precisar de sincronização.
* **Uso comum de `volatile`**: Para variáveis que não precisam de sincronização, mas precisam ser acessadas por múltiplas threads.

### Tópicos:

* Como o `volatile` ajuda a garantir a visibilidade de variáveis
* **Exemplo**: Variável compartilhada entre threads sem sincronização explícita, mas com `volatile`.

**Próximo passo**: Podemos criar um exemplo simples de um contador e ver a diferença entre usar e não usar `volatile`.

## **5) Concorrência em Coleções (Collections Concurrentes)**

Quando você usa **coleções** como listas ou mapas em um cenário de múltiplas threads, pode ser necessário garantir que a coleção esteja **segura** para o acesso simultâneo, ou seja, que a integridade da coleção não seja comprometida.

### Conceitos:

* **Problemas com coleções comuns** (como `ArrayList` ou `HashMap`) quando acessadas por várias threads simultaneamente.
* **Collections sincronizadas** e **coleções concorrentes**: Como `CopyOnWriteArrayList` e `ConcurrentHashMap`.

### Tópicos:

* Como usar coleções seguras para múltiplas threads
* **Exemplo prático** de `ConcurrentHashMap` para simular concorrência segura em uma coleção.

**Próximo passo**: Podemos fazer uma implementação prática com uma **`ConcurrentHashMap`** para mostrar como ele evita problemas de concorrência.

## **Resumindo:**

* **Parte 1**: Sincronização (simples, método e bloco)
* **Parte 2**: Condições de Corrida (e como preveni-las)
* **Parte 3**: Deadlocks (identificação e prevenção)
* **Parte 4**: Visibilidade de Variáveis (`volatile`)
* **Parte 5**: Concorrência em Coleções (coleções seguras para múltiplas threads)
