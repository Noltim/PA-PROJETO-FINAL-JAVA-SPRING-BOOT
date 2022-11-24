import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewInspecao() {
  const [inspecao, setInspecao] = useState([]);

  useEffect(() => {
    loadObras();
  }, []);

  const { id } = useParams();


  let token = localStorage.getItem("user")
  const loadObras = async () => {
    const result = await axios.get(`http://localhost:8080/api/inspecoes`, { headers: { "Authorization": token } })
    console.log(result.data);
    setInspecao(result.data);
  };

  const deleteObras = async (id) => {
    await axios.delete(`http://localhost:8080/api/inspecoes/${id}`, { headers: { "Authorization": token } })
    loadObras();
  }

  return (
    <div className='conteiner'>

      <div className='p-5'>
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Obra</th>
              <th scope="col">Data</th>
              <th scope="col">Observação</th>
              <th scope="col">Ação</th>
            </tr>
          </thead>
          <tbody>
            {
              inspecao.map((insp, index) => (
                <tr>
                  <th scope='row' key={index}>{index + 1}</th>
                  <td>{insp.obraInspecaoId.frequencia}</td>
                  <td>{insp.data}</td>
                  <td>{insp.observacoes}</td>
                  <td>
                    <Link
                      to={`/viewobrainspecaoid/${insp.id}`} className='btn btn-primary mx-2'>View</Link>
                    <Link
                      to={`/editinspecao/${insp.id}`}
                      className='btn btn-outline-primary mx-2'>Editar
                    </Link>
                    <button className='btn btn-danger mx-2'
                      onClick={() => deleteObras(insp.id)}
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