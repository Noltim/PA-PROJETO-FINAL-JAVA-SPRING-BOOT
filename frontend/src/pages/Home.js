import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import '../home.css'

export default function Home() {


  return (

    <div className='container'>
      {!localStorage.length ?
        <div class="alert alert-primary" role="alert">
          Para acessar as consultas será necessário estar logado no sistema.
        </div> : ""
      }
      <div className='py-4'>
        <table className='main-table'>
          <thead>
            <tr>
              <th scope="col">Consultas</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>

            <tr className='table-linhas cor-sim'>

              <td>Obras</td>
              <td>
                <Link className='botao-create' to="/addobra">Create</Link>
                <Link className='botao-view'to="/viewobra">View</Link>

              </td>
            </tr>
            <tr className='table-linhas'>

              <td>Obras Localização</td>
              <td>
                <Link className='botao-create' to="/addobralocal">Create</Link>
                <Link className='botao-view' to="/viewobralocal">View</Link>

              </td>
            </tr>
            <tr className='table-linhas cor-sim'>

              <td>Obras Detalhes Tecnicos</td>
              <td>
                <Link className='botao-create' to="/addobradetalhes">Create</Link>
                <Link className='botao-view' to="/viewobradetalhes">View</Link>

              </td>
            </tr>
            <tr className='table-linhas'>

              <td>Obras Inspeções</td>
              <td>
                <Link className='botao-create' to="/addobrainspecao">Create</Link>
                <Link className='botao-view' to="/viewobrainspecao">View</Link>

              </td>
            </tr>
            <tr className='table-linhas cor-sim'>

              <td>Inspeções</td>
              <td>
                <Link className='botao-create' to="/addinspecao">Create</Link>
                <Link className='botao-view' to="/viewinspecao">View</Link>
              </td>
            </tr>
            
          </tbody>
        </table>
      </div>
    </div>
  )
}
