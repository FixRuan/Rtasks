# Rtasks
Todo tasks with java web

## Capa
<img src="./Capa.png" /> <br/> <br/>

- [x] Cadastro de usuários
- [x] Login de usuários
- [x] Loggout de usuários
- [x] Cadastro de tarefas
- [ ] Listagem de tarefas
- [ ] remoção de tarefas

## Design da aplicação
- Clique [aqui](https://www.figma.com/file/dgpER6x7FBWYfpBISgb5SV/ToDo-List?node-id=0%3A1) para acessar o layout no Figma

## Tables
```
CREATE TABLE "USERS" (
    "ID" INTEGER not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    "NAME" VARCHAR(200) not null,
    "EMAIL" VARCHAR(200) not null,
    "PASSWORD" VARCHAR(200) not null
);

CREATE TABLE "TASKS" (
    "ID" INTEGER not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    "NAME" VARCHAR(200) not null,
    "IMAGE_TYPE" VARCHAR(200) not null,
    "IMAGE_CONTENT" BLOB not null,
)
```
