import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'


export default function Home() {

  
  return (

    <div className='container'>
      {  !localStorage.length? 
      <div class="alert alert-primary" role="alert">
        Para acessar as consultas será necessário estar logado no sistema.
      </div>:""
      }
      <div className='py-4'>
        <table className="table table-bordered shadow table-striped">
          <thead className="table-dark">
            <tr>

              <th scope="col">Consultas</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>

            <tr>

              <td>Obras</td>
              <td>
                <Link className="btn btn-primary mx-2" to="/addobra">Create</Link>
                <Link className="btn btn-outline-primary mx-2" to="/viewobra">View</Link>

              </td>
            </tr>
            <tr>

              <td>Obras Localização</td>
              <td>
                <Link className="btn btn-primary mx-2" to="/addobralocal">Create</Link>
                <Link className="btn btn-outline-primary mx-2" to="/viewobralocal">View</Link>

              </td>
            </tr>
            <tr>

              <td>Obras Detalhes Tecnicos</td>
              <td>
                <Link className="btn btn-primary mx-2" to="/addobradetalhes">Create</Link>
                <Link className="btn btn-outline-primary mx-2" to="/viewobradetalhes">View</Link>

              </td>
            </tr>
            <tr>

              <td>Obras Inspeções</td>
              <td>
                <Link className="btn btn-primary mx-2" to="/addobrainspecao">Create</Link>
                <Link className="btn btn-outline-primary mx-2" to="/viewobrainspecao">View</Link>

              </td>
            </tr>
            <tr>

              <td>Inspeções</td>
              <td>
                <Link className="btn btn-primary mx-2" to="/addinspecao">Create</Link>
                <Link className="btn btn-outline-primary mx-2" to="/viewinspecao">View</Link>
              </td>
            </tr>



          </tbody>
        </table>
      </div>
    </div>
  )
}
