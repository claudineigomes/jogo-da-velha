# Jogo da Velha

Simples API para jogo da velha

### Pré requisitos
```
Java
Maven
```

### Rodando o projeto

Pelo terminal do linux basta rodar o comando abaixo que o tomcat embutido na aplicação já irá subir
```
mvn clean install
java -jar target/game-0.0.1-SNAPSHOT.jar 
```

## Rodando os testes

```
mvn test 
```

## Exemplo
```
curl -X POST http://localhost:8080/game
{"id":"4f01f603-8090-4dc1-992e-99b9597b9ff1","firstPlayer":"X"}% 

curl -X POST \
  http://localhost:8080/game/4f01f603-8090-4dc1-992e-99b9597b9ff1/movement \
  -H 'Content-Type: application/json' \
  -d '{
 "id" : "4f01f603-8090-4dc1-992e-99b9597b9ff1",
 "player": "X",
 "position": {
 "x": 0,
 "y": 0
 }
}'
{"msg":"Não é turno do jogador"}

```

Também acessando pelo browser a url http://localhost:8080 será aberto uma interface para o jogo:

![Print Jogo da Velha](print.png?raw=true "Print Jogo da Velha")

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management