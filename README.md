
# ProjetoJava-FrontEnd

Repositório para entrega final da aceleração de Java na Trybe

Link do Front-End para consumir a api: https://github.com/LeonardoZaramello/projetojava-frontend


## Documentação da API


### Rotas referentes aos drones

#### Retorna todos os drones
```
  GET /drones/
```


#### Retorna um drone
```
  GET /drones/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer ver |


#### Adiciona um drone
```
  POST /drones/
```
Passando no body um json no formato:
```json
    {
      "marca": "Marca Exemplo.",
      "modelo": "Modelo Exemplo."
    }
```


#### Modifica as informações de marca e modelo de um drone
```
  PUT /drones/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer alterar |

Passando no body um json no formato:
```json
    {
      "marca": "Outra Marca.",
      "modelo": "Outro Modelo."
    }
```


#### Deleta um drone
```
  DELETE /drones/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer deletar |


#
### Rotas referentes às entregas

#### Retorna todas as entregas
```
  GET /entregas/
```


#### Retorna uma entrega
```
  GET /entregas/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer ver |


#### Adiciona uma entrega
```
  POST /entregas/
```
Passando no body um json no formato:
```json
    {
      "longitude": "50.457563",
      "latitude": "35.765342"
    }
```


#### Modifica as informações de longitude e latitude
```
  PUT /entregas/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer alterar |

Passando no body um json no formato:
```json
    {
      "longitude": "76.874221",
      "latitude": "23.975624"
    }
```


#### Deleta uma entrega
```
  DELETE /entregas/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer deletar |

## Deploy

Para subir a api, rode na raiz do diretório:

```bash
  mvn install
```
```bash
  mvn spring-boot:run
```

## Melhorias

Testes integrados.

