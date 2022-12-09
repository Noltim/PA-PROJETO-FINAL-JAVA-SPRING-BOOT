import axios, { Axios } from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewObraDetalhes() {
  const [obrasInspencao, setObrasInspencao] = useState([]);

  useEffect(() => {
    loadObras();
  }, []);

  const {id} = useParams();

  let token = localStorage.getItem("user")
  
  const loadObras = async () => {
    const result = await axios.get(`http://localhost:8080/api/detalhesobra`, { headers: { "Authorization": token } })
    console.log(result.data);
    setObrasInspencao(result.data);
  };

  const deleteObras = async (id) => {
    await axios.delete(`http://localhost:8080/api/detalhesobra/${id}`, { headers: { "Authorization": token } })
    loadObras();
  }

  return (
    <div className='conteiner text-light'>

      <div className='p-5'>
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">obra</th>
              <th scope="col">Tipo</th>
              <th scope="col">Risco</th>
              <th scope="col">Ação</th>
            </tr>
          </thead>
          <tbody>
          {
              obrasInspencao.map(( obra, index ) => (
              <tr>
                <th scope='row' key={index}>{index + 1}</th>
                <td>{obra.obraId.nome}</td>
                <td>{obra.tipo}</td>
                <td>{obra.risco}</td>
                <td>
                  <Link 
                  to={`/viewobradetalheid/${obra.id}`} className='btn btn-primary mx-2'>View</Link>
                  <Link 
                  to={`/editobradetalhes/${obra.id}`}
                  className='btn btn-outline-primary mx-2'>Editar
                  </Link>
                  <button className='btn btn-danger mx-2'
                    onClick={()=>deleteObras(obra.id)}
                  >Deletar</button>
                </td>
              </tr>
              ))
            }
            
          </tbody>
        </table>
      </div>
    </div>
  )
}