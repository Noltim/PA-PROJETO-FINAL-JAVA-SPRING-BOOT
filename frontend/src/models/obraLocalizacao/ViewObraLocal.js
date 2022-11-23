import axios, { Axios } from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewObraLocal() {
  const [obras, setObras] = useState([]);

  useEffect(() => {
    loadObras();
  }, []);

  const {id} = useParams();

  
  let token = localStorage.getItem("user")
  const loadObras = async () => {
    const result = await axios.get(`http://localhost:8080/api/obralocal`, { headers: { "Authorization": token } })
    console.log(result.data);
    setObras(result.data);
  };

  const deleteObras = async (id) => {
    await axios.delete(`http://localhost:8080/api/obralocal/${id}`, { headers: { "Authorization": token } })
    loadObras();
  }

  return (
    <div className='conteiner'>

      <div className='p-5'>
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">obra</th>
              <th scope="col">cidade</th>
              <th scope="col">estado</th>
              <th scope="col">latitude</th>
              <th scope="col">longitude</th>
              <th scope="col">Ação</th>
            </tr>
          </thead>
          <tbody>
          {
              obras.map(( obra, index ) => (
              <tr>
                <th scope='row' key={index}>{index + 1}</th>
                <td>{obra.obraId.nome}</td>
                <td>{obra.cidade}</td>
                <td>{obra.estado}</td>
                <td>{obra.latitude}</td>
                <td>{obra.longitude}</td>
                <td>
                  <Link 
                  to={`/viewobralocalid/${obra.id}`} className='btn btn-primary mx-2'>View</Link>
                  <Link 
                  to={`/editobralocal/${obra.id}`}
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