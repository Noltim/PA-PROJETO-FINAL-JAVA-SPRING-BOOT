import axios, { Axios } from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';
import { axiosInstance } from '../../api/api';

export default function ViewObra() {
  const [obras, setObras] = useState([]);

  // const onInputChange = (e) => {
  //   setObras({ ...user, [e.target.name]: e.target.value })
  // };

  useEffect(() => {
    loadObras();
  }, []);

  const {id} = useParams();

  
  let token = localStorage.getItem("user")
  const loadObras = async () => {
    // const result = await axiosInstance.post("http://localhost:8080/api/obras", user, {headers:{"Authorization": token}})
    // const result = await axiosInstance.get(`http://localhost:8080/api/obras`, { headers: { "Authorization": token } })
    const result = await axios.get(`http://localhost:8080/api/obras`, { headers: { "Authorization": token } })

    // const result = await axiosInstance.get("http://localhost:8080/api/obras", obras, {headers:{"Authorization": token}})
    // navigate("/")
    console.log(result.data);
    setObras(result.data);
  };

  const deleteObras = async (id) => {
    await axios.delete(`http://localhost:8080/api/obras/${id}`, { headers: { "Authorization": token } })
    loadObras();
  }

  return (
    <div className='conteiner'>

      <div className='p-5'>
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">nome</th>
              <th scope="col">anoConstrucao</th>
              <th scope="col">gerencia</th>
              <th scope="col">diretoria</th>
              <th scope="col">outorga</th>
              <th scope="col">titularidade</th>
              <th scope="col">Ação</th>
            </tr>
          </thead>
          <tbody>
          {
              obras.map(( obra, index ) => (
              <tr>
                <th scope='row' key={index}>{index + 1}</th>
                <td>{obra.nome}</td>
                <td>{obra.anoConstrucao}</td>
                <td>{obra.gerencia}</td>
                <td>{obra.diretoria}</td>
                <td>{obra.outorga}</td>
                <td>{obra.titularidade}</td>
                <td>
                  <Link 
                  to={`/viewobraid/${obra.id}`} className='btn btn-primary mx-2'>View</Link>
                  <Link 
                  to={`/editobra/${obra.id}`}
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