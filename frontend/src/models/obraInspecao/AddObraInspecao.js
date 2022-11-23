import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddObraInspecao() {
  const [obraInpecao, setObraInpecao] = useState({
    frequencia: "",
    mes: "",
    status: "",
    prioridade: "",
    obraId: ""
  })

  let frequenciaEnum = [
    {
      id: 0,
      nome: 'Anual',
    },
    {
      id: 1,
      nome: 'Bienal',

    },
    {
      id: 2,
      nome: 'Quinquenal',

    },
  ]

  let statusEnum = [
    {
      id: 0,
      nome: 'Pendente',
    },
    {
      id: 1,
      nome: 'Atualizado',
    },
  ]

  const { frequencia, mes, status, prioridade, obraId } = obraInpecao;

  const [obras, setObras] = useState([]);

  let navigate = useNavigate()

  const onInputChange = (e) => {
    setObraInpecao({ ...obraInpecao, [e.target.name]: e.target.value })
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    console.log(obraInpecao)
    obraInpecao.obraId = { id: obraId };
    console.log(obraInpecao)
    let token = localStorage.getItem("user")
    await axios.post(`http://localhost:8080/api/obrainspecoes`, obraInpecao, { headers: { "Authorization": token } })
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
              <label htmlFor='Name' className='form-label'> frequência</label>
              <select onChange={(e) => onInputChange(e)} className="form-control" name='frequencia' value={frequencia} >
                <option value=""> -- Seleciona a frequência-- </option>
                {
                  frequenciaEnum.map((frequencia, index) => (
                    <option key={frequencia.id} value={frequencia.id}>{frequencia.id+1} | {frequencia.nome}</option>
                  ))
                }
              </select>
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> status</label>
              <select onChange={(e) => onInputChange(e)} className="form-control" name='status' value={status} >
                <option value=""> -- Seleciona o Status-- </option>
                {
                  statusEnum.map((status, index) => (
                    <option key={status.id} value={status.id}>{status.id+1} | {status.nome}</option>
                  ))
                }
              </select>
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> mês</label>
              <input value={mes} type={"number"} className="form-control" placeholder='mes' name='mes' onChange={(e) => onInputChange(e)} />
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> prioridade</label>
              <input value={prioridade} type={"number"} className="form-control" placeholder='prioridade' name='prioridade' onChange={(e) => onInputChange(e)} />
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