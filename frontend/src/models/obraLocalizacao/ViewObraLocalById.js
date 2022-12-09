import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';
import { axiosInstance } from '../../api/api';

export default function ViewObraLocalById() {

  const [obra, setObra] = useState({
    nome: "",
    cidade: "",
    estado: "",
    latitude: "",
    longitude: "",
    outorga: "",
    obraId: ""

  });
  
  const{id} = useParams();

  const loadObra = async () => {
    let token = localStorage.getItem("user")
    const result = await axios.get(`http://localhost:8080/api/obralocal/${id}`, { headers: { "Authorization": token } })
    setObra(result.data);

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
              Details of obra id: {obra.id}
              <ul className='list-group list-group-item'>
                <li className='list-group-item'>
                  <b>Obra: </b>
                  {obra.obraId.nome}
                </li>
                <li className='list-group-item'>
                  <b>cidade: </b>
                  {obra.cidade}
                </li>
                <li className='list-group-item'>
                  <b>estado: </b>
                  {obra.estado}
                </li>
                <li className='list-group-item'>
                  <b>latitude: </b>
                  {obra.latitude}
                </li>
                <li className='list-group-item'>
                  <b>longitude: </b>
                  {obra.longitude}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to="/viewobralocal">Voltar</Link>
        </div>
      </div>
    </div>
  )
}