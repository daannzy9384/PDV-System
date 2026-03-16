import { useState } from "react";
import "./App.css";

function App() {

  const [products, setProducts] = useState([]);
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [qty, setQty] = useState(1);

  function addProduct() {

    if (!name || !price) return;

    const newProduct = {
      name: name,
      price: Number(price),
      qty: Number(qty)
    };

    setProducts([...products, newProduct]);

    setName("");
    setPrice("");
    setQty(1);
  }

  function removeProduct(index) {
    const updated = products.filter((_, i) => i !== index);
    setProducts(updated);
  }

  function clearSale() {
    setProducts([]);
  }

  function finishSale() {
    alert("Venda finalizada!");
    setProducts([]);
  }

  const total = products.reduce(
    (sum, p) => sum + p.price * p.qty,
    0
  );

  return (
    <div className="container">
      <h1>PDV - Mercadinho do Dan e Vk</h1>

      <div className="add-product">

        <input
          placeholder="Produto"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <input
          type="number"
          placeholder="Preço"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />

        <input
          type="number"
          placeholder="Qtd"
          value={qty}
          onChange={(e) => setQty(e.target.value)}
        />

        <button onClick={addProduct}>
          Adicionar
        </button>

      </div>

      <h2>Itens da venda</h2>

      <table>

        <thead>
          <tr>
            <th>Produto</th>
            <th>Preço</th>
            <th>Qtd</th>
            <th>Total</th>
            <th>Ação</th>
          </tr>
        </thead>

        <tbody>

          {products.map((p, index) => (
            <tr key={index}>

              <td>{p.name}</td>
              <td>R$ {p.price}</td>
              <td>{p.qty}</td>
              <td>R$ {p.price * p.qty}</td>

              <td>
                <button onClick={() => removeProduct(index)}>
                  Remover
                </button>
              </td>

            </tr>
          ))}

        </tbody>

      </table>

      <h2 className="total">
        Total: R$ {total}
      </h2>

      <div className="actions">

        <button onClick={finishSale}>
          Finalizar venda
        </button>

        <button onClick={clearSale}>
          Cancelar venda
        </button>

      </div>

    </div>
  );
}

export default App;