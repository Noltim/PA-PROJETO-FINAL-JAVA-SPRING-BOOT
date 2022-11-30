import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewObraId() {

  const [obra, setObra] = useState({
    nome: "",
    anoConstrucao: "",
    coordenacao: "",
    gerencia: "",
    diretoria: "",
    outorga: "",
    titularidade: ""

  });
  const{id} = useParams();

  const loadObra = async () => {
    let token = localStorage.getItem("user")
    const result = await axios.get(`http://localhost:8080/api/obras/${id}`, { headers: { "Authorization": token } })
    setObra(result.data);

  }

  useEffect(() => {
    loadObra()
  }, []);

  return (
    <div className='conteiner text-light'>
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4"> Obra Detalhes id : ${obra.id}</h2>
          {/* <form>
            <div className="mb-3">
              <label htmlFor="id" className='form-label'>
                id do usuário: </label>
              <input
                type="text"
                className="form-control"
                name='id'
                value={id}
                placeholder="insira um ID de usuário"
                onChange={({ target }) => setId(target.value)}

              />
            </div>
            <button className="btn btn-outline-success">Search ID</button>
          </form> */}
          <div className="card">
            <div className='card-header'>
              Detalhe da Obra: {obra.id}
              <ul className='list-group list-group-item'>
                <li className='list-group-item'>
                  <b>Nome:</b>
                  {obra.nome}
                </li>
                <li className='list-group-item'>
                  <b>anoConstrucao:</b>
                  {obra.anoConstrucao}
                </li>
                <li className='list-group-item'>
                  <b>coordenacao:</b>
                  {obra.coordenacao}
                </li>
                <li className='list-group-item'>
                  <b>gerencia:</b>
                  {obra.gerencia}
                </li>
                <li className='list-group-item'>
                  <b>diretoria:</b>
                  {obra.diretoria}
                </li>
                <li className='list-group-item'>
                  <b>outorga:</b>
                  {obra.outorga}
                </li>
                <li className='list-group-item'>
                  <b>titularidade:</b>
                  {obra.titularidade}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/viewobra"}>Voltar</Link>
        </div>
      </div>
    </div>
  )
}