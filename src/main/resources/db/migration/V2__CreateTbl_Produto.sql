create table tbl_produto (
        categoria_id bigint not null,
        id bigserial not null,
        nome varchar(255) not null,
        unidade_de_medida varchar(255) check (unidade_de_medida in ('KG','DUZIA','UNIDADE')),
        primary key (id)
    )