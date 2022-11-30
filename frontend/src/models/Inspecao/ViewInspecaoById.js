import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';
import { axiosInstance } from '../../api/api';

export default function ViewInspecaoById() {

  const [inspecao, setInspecao] = useState({
    obraInspecaoId: "",
    data: "",
    observacoes: "",
  });
  
  const{id} = useParams();

  const loadObra = async () => {
    let token = localStorage.getItem("user")
    const result = await axios.get(`http://localhost:8080/api/inspecoes/${id}`, { headers: { "Authorization": token } })
    setInspecao(result.data);

  }

  useEffect(() => {
    loadObra()
  }, []);


  return (
    <div className='conteiner text-light'>
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <div className="card">
            <div className='card-header'>
               inspecao id: {inspecao.id}
              <ul className='list-group list-group-item'>
                <li className='list-group-item'>
                  <b>Obra Inspenção: </b>
                  {inspecao.obraInspecaoId.obraId.nome}
                </li>
                <li className='list-group-item'>
                  <b>data: </b>
                  {inspecao.data}
                </li>
                <li className='list-group-item'>
                  <b>Observação: </b>
                  {inspecao.observacoes}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to="/viewinspecaolocal">Voltar</Link>
        </div>
      </div>
    </div>
  )
}