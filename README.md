#  Workshop: Integração MongoDB + Spring Boot  

[![My Skills](https://skillicons.dev/icons?i=java,spring,mongodb)](https://skillicons.dev)  
![Status](https://img.shields.io/badge/Concluído-brightgreen)  

##  Visão Geral  
Este projeto foi desenvolvido em um **workshop prático**, com foco em integrar o **Spring Boot** a um banco **NoSQL (MongoDB)**.  
O sistema simula um **mini blog** com três entidades principais:  

- **Post**  
- **Comentários**  
- **Usuário**  

O objetivo foi ver como o uso do **MongoDB** se mostra mais eficiente nesse caso, já que os dados dessas entidades se relacionam naturalmente e podem ser recuperados em **uma única chamada**, diferente de um banco relacional que exigiria vários *joins*.  

---

##  Funcionalidades  
- Criação e gerenciamento de Posts.  
- Associação de Comentários a Posts.  
- Usuários relacionados às publicações.  
- Consultas rápidas e otimizadas com **Spring Data MongoDB**.  

---

##  Aprendizados Técnicos  
- Diferença prática entre **SQL vs. NoSQL**.  
- Modelagem de dados em **MongoDB** utilizando Spring Data.  
- Escrita de **queries customizadas** em JSON.  
- Uso do **MongoDB Compass** para visualização e gerenciamento.  


##  Tecnologias Utilizadas  
[![My Skills](https://skillicons.dev/icons?i=java,spring,mongodb,docker,git,github)](https://skillicons.dev)  

- **Java 21**  
- **Spring Boot**  
- **Spring Data MongoDB**  
- **MongoDB**  
- **Docker**  
- **Git & GitHub**  

---

## 🏗️ Cenário de Estudo  
- **SQL:** exigiria múltiplos *joins* para unir Posts, Comentários e Usuários.  
- **NoSQL (MongoDB):** armazena os dados relacionados juntos, otimizando consultas e melhorando performance em cenários de **alta requisição**.  

