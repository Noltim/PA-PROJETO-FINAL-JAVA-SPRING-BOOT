import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';

export default function EditObraDetalhes() {
  const [obraDetalhe, setObrasDetalhes] = useState({
    tipo: "",
    risco: "",
    obraId: ""
  })

  const { tipo, risco, obraId } = obraDetalhe;

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

  let navigate = useNavigate()
  let token = localStorage.getItem("user")

  const { id } = useParams();

  const onInputChange = (e) => {
    setObrasDetalhes({ ...obraDetalhe, [e.target.name]: e.target.value })
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    console.log(obraDetalhe)
    obraDetalhe.obraId = { id: obraId };
    console.log(obraDetalhe)
    let token = localStorage.getItem("user")
    await axios.put(`http://localhost:8080/api/detalhesobra/${id}`, obraDetalhe, { headers: { "Authorization": token } })
    navigate("/viewobradetalhes");
  }

  useEffect(() => {
    loadObrasLocal();
  }, [])

  const loadObrasLocal = async () => {
    const result = await axios.get(`http://localhost:8080/api/detalhesobra/${id}`, { headers: { "Authorization": token } })
    console.log(result.data)
    
    setObrasDetalhes(trocandoValoresEnum(result.data))
    console.log(result.data)
  }

  const trocandoValoresEnum = (result) => {
    
    if (result.tipo == "HIDRAULICA")
      result.tipo = "0"
    if (result.tipo == "ESTRUTURAL")
      result.tipo = "1"
    if (result.tipo == "GEOTECNICA")
      result.tipo = "2"

    if (result.risco == "BAIXO")
      result.risco = "0"
    if (result.risco == "MEDIO")
      result.risco = "1"
    if (result.risco == "ALTO")
      result.risco = "2"


    // result.obraId = obraId.id ;

    return result;
  }

  const [obras, setObras] = useState([]);

  useEffect(() => {
    loadObras();
  }, []);

  const loadObras = async () => {
    const result = await axios.get(`http://localhost:8080/api/obras`, { headers: { "Authorization": token } })
    setObras(result.data);
  };

  return (
    <div className='conteiner text-light'>
      <div className='row'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2'>
          <h2 className='text-center m-4'>Registro Obras Inspenção</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Tipo da Obra</label>

              <select onChange={(e) => onInputChange(e)} className="form-control" name='tipo' value={tipo} >
                <option value=""> -- Seleciona a tipo-- </option>
                {
                  tipoEnum.map((tipo, index) => (
                    <option key={tipo.id} value={tipo.id}>{tipo.id + 1} | {tipo.nome}</option>
                  ))
                }
              </select>
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Risco da Obra</label>
              <select onChange={(e) => onInputChange(e)} className="form-control" name='risco' value={risco} >
                <option value=""> -- Seleciona o risco-- </option>
                {
                  riscoEnum.map((risco, index) => (
                    <option key={risco.id} value={risco.id}>{risco.id + 1} | {risco.nome}</option>
                  ))
                }
              </select>
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Obras</label>
              <select onChange={(e) => onInputChange(e)} className="form-control" name='obraId' value={obraId.id} >
                <option value="0"> -- Seleciona a obra-- </option>
                {
                  obras.map((obra, index) => (
                    <option key={obra.id} value={obra.id}>{obra.id} | {obra.nome}</option>
                  ))
                }
              </select>

            </div>

            <button type='submit' className='btn btn-outline-primary'>Salvar</button>
            <Link className="btn btn-outline-danger mx-2" to="/viewobradetalhes">
              Cancel
            </Link>

          </form>
        </div>
      </div>

    </div>
  )
}