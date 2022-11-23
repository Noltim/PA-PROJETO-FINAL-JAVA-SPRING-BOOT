import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import { axiosInstance } from '../../api/api';

export default function ViewObraById() {

  const [obra, setObra] = useState({
    nome: "",
    anoConstrucao: "",
    coordenacao: "",
    gerencia: "",
    diretoria: "",
    outorga: "",
    titularidade: ""

  });
  const [id, setId] = useState("");

  useEffect(() => {
    const loadObra = async () => {
      let token = localStorage.getItem("user")
      const result = await axiosInstance.get(`http://localhost:8080/api/obras/${id}`,{headers:{"Authorization": token}})
      setObra(result.data);
     
    }
    loadObra()
  }, []);



  return (
    <div className='conteiner'>
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4"> Obra Detalhes</h2>
          <form>
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
          </form>
          <div className="card">
            <div className='card-header'>
              Details of obra id: {obra.id}
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
          <Link className="btn btn-primary my-2" to="/">Back to home</Link>
        </div>
      </div>
    </div>
  )
}