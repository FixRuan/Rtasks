# Rtasks
Todo tasks with java web


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
