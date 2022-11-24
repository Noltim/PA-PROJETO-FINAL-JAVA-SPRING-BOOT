import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddObraDetalhes() {
  const [obrasDetalhes, setObrasDetalhes] = useState({
    tipo: "",
    risco: "",
    obraId: ""
  })

  let tipoEnum = [
    {
      id: 0,
      nome: 'Hidraulica',
    },
    {
      id: 1,
      nome: 'Estrutural',

    },
    {
      id: 2,
      nome: 'Geotecnica',

    },
  ]

  let riscoEnum = [
    {
      id: 0,
      nome: 'Baixo',
    },
    {
      id: 1,
      nome: 'Médio',
    },
    {
      id: 2,
      nome: 'Alto',
    },
  ]

  const { tipo, risco, obraId } = obrasDetalhes;

  const [obras, setObras] = useState([]);

  let navigate = useNavigate()

  const onInputChange = (e) => {
    setObrasDetalhes({ ...obrasDetalhes, [e.target.name]: e.target.value })
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    console.log(obrasDetalhes)
    obrasDetalhes.obraId = { id: obraId };
    console.log(obrasDetalhes)
    let token = localStorage.getItem("user")
    await axios.post(`http://localhost:8080/api/detalhesobra`, obrasDetalhes, { headers: { "Authorization": token } })
    navigate("/");
  }

  useEffect(() => {
    loadObras();
  }, []);

  const loadObras = async () => {
    let token = localStorage.getItem("user")
    const result = await axios.get(`http://localhost:8080/api/obras`, { headers: { "Authorization": token } })
    // console.log(result.data);
    setObras(result.data);
  };

  return (
    <div className='conteiner'>
      <div className='row'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2'>
          <h2 className='text-center m-4'>Registro Obras Inspenção</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Tipo Obra</label>
              <select onChange={(e) => onInputChange(e)} className="form-control" name='tipo' value={tipo} >
                <option value=""> -- Seleciona o tipo -- </option>
                {
                  tipoEnum.map((tipo, index) => (
                    <option key={tipo.id} value={tipo.id}>{tipo.id+1} | {tipo.nome}</option>
                  ))
                }
              </select>
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Risco Obra</label>
              <select onChange={(e) => onInputChange(e)} className="form-control" name='risco' value={risco} >
                <option value=""> -- Seleciona o risco -- </option>
                {
                  riscoEnum.map((risco, index) => (
                    <option key={risco.id} value={risco.id}>{risco.id+1} | {risco.nome}</option>
                  ))
                }
              </select>
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Obras</label>
              <select onChange={(e) => onInputChange(e)} className="form-control" name='obraId' value={obraId} >
                <option value="0"> -- Seleciona a obra-- </option>
                {
                  obras.map((obra, index) => (
                    <option key={obra.id} value={obra.id}>{obra.id} | {obra.nome}</option>
                  ))
                }
              </select>

            </div>

            <button type='submit' className='btn btn-outline-primary'>Salvar</button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>

          </form>
        </div>
      </div>

    </div>
  )
}