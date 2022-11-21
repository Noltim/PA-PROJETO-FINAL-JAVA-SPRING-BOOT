import React, { useEffect, useState } from 'react'
import { axiosInstance } from '../api/api';

export default function Home() {

  const [users, setUsers] = useState([])

  useEffect(() => {
    const loadUsers = async () => {
      const result = await axiosInstance.get(`http:/localhost:8080/api/obras/${id}`)
      setUsers(result.data);
    };
    loadUsers();
  }, []);



  return (
    <div className='container'>
      <div className='py-4'>
        <table className="table table-bordered shadow table-striped">
          <thead className="table-dark">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Obra</th>
              <th scope="col">Ano</th>
              <th scope="col">Coordenação</th>
              <th scope="col">Gerencia</th>
              <th scope="col">Diretoria</th>
              <th scope="col">Outorga</th>
              <th scope="col">Titularidade</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>

            {
              users.map((user, index) => {
                <tr>
                  <th scope="row" key={index}>{index + 1}</th>
                  <td>{user.nome}</td>
                  <td>{user.anoConstrucao}</td>
                  <td>{user.coordenacao}</td>
                  <td>{user.gerencia}</td>
                  <td>{user.diretoria}</td>
                  <td>{user.outorga}</td>
                  <td>{user.titularidade}</td>
                  <td>
                    <button className="btn btn-primary mx-2">View</button>
                    <button className="btn btn-outline-primary mx-2">Edit</button>
                    <button className="btn btn-danger mx-2">Delete</button>
                  </td>
                </tr>
              })
            }


          </tbody>
        </table>
      </div>
    </div>
  )
}
