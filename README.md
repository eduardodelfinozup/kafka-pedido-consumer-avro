# kafka-restaurante consumidor
# Criar Restaurante:
```
curl --request POST \
  --url localhost:8082/clientes \
  --header 'Content-Type: application/json' \
  --data '
	{
	    "nomeFantasia":"Restaurante full",
	    "documento":"doc2",
	    "site":"www.restaurante.com.br",
	    "telefone":"3432212257"

}

```

# Buscar Restaurante

```
curl --request GET \
  --url localhost:8082/clientes/2\

```
# Nova venda

```
curl --location --request POST 'localhost:8081/autores' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome":"Augusto curi",
    "biografia":"Inteligência Multifocal",
    "nascimento":"01-07-1979",
    "nacionalidade":"Brasileira"
}'
```

```
curl --location --request POST 'localhost:8081/categorias' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome":"Auto ajuda"
    
}'
```

```
curl --location --request POST 'localhost:8081/livros' \
--header 'Content-Type: application/json' \
--data-raw '{
    "titulo":"Augusto curi",    
    "dataDeLancamento":"01-07-1979",
    "nacionalidade":"Brasileira",
    "resumo":"Inteligência Multifocal",
    "idioma":"Português",
    "idCategoria":1,
    "idAutor":1,
    "formato":"IMPRESSO_CAPA_DURA",
    "paginas":235,
    "alterado":"08-04-2023"
}'
```

```
curl --location --request POST 'localhost:8081/estoque' \
--header 'Content-Type: application/json' \
--data-raw '{
    "idLivro":1,
    "quantidade":1000,
    "valorUnitario":67.99
}'
```

```
curl --location --request POST 'localhost:8081/vendas' \
--header 'Content-Type: application/json' \
--data-raw '{
    "idLivro":1,
    "tipoPagamento":"DINHEIRO",
    "emailCliente":"augusto.curi@gmail.com"
}'
```
