## Microsserviço de Pedidos

Este microserviço de pedidos faz parte de:
- https://github.com/gusttv/vun-hono-bff

### Instalação e Execução
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   cd order-microservice
   ```
2. **Configure as variáveis de ambiente:**
    * `SPRING_DATASOURCE_URL`
    * `SPRING_DATASOURCE_USERNAME`
    * `SPRING_DATASOURCE_PASSWORD`
    * `API_SECURITY_TOKEN_SECRET` (caso necessário para autenticação)
3. **Execute o projeto:**
   ```bash
   docker compose up -d
   mvn spring-boot:run
   ```

### Endpoints
* **POST /orders:** Cria um novo pedido.
    - **Request Body**:
      ```json
      {
        "userId": "bba8c72e-dfab-4c27-8a14-b8bb09f83e0b",
        "product": "Camisa",
        "quantity": 2,
        "price": 59.90
      }
      ```
    - **Response**:
      ```json
      {
        "id": "uuid",
        "userId": "bba8c72e-dfab-4c27-8a14-b8bb09f83e0b",
        "product": "Camisa",
        "quantity": 2,
        "price": 59.90,
        "orderDate": "2024-11-12T10:00:00Z",
        "orderStatus": "PENDING"
      }
      ```
* **GET /orders:** Retorna a lista de todos os pedidos.
* **GET /orders/{id}**: Retorna um pedido específico pelo ID.
* **PATCH /orders/{id}/status?status=CONFIRMED**: Atualiza o status de um pedido.
* **DELETE /orders/{id}**: Exclui um pedido específico.

