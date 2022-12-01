import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddObra() {
  const [obra, setObras] = useState({
    nome: "",
    anoConstrucao: "",
    coordenacao: "",
    gerencia: "",
    diretoria: "",
    outorga: "",
    titularidade: ""
  })

  const { nome, anoConstrucao, coordenacao, gerencia, diretoria, outorga, titularidade } = obra;
  
  let navigate=useNavigate()

  const onInputChange = (e) => {
    setObras({ ...obra, [e.target.name]: e.target.value })
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    let token = localStorage.getItem("user")
    await axios.post(`http://localhost:8080/api/obras`, obra, { headers: { "Authorization": token } })
    navigate("/");
  }

  return (
    <div className='conteiner text-light cor-fundo'>
      <div className='row'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2'>
          <h2 className='text-center m-4'>Registro Obras</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Nome</label>
              <input value={nome} type={"text"} className="form-control" placeholder='Nome Obra' name='nome' onChange={(e) => onInputChange(e)} />
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'>Ano Construção</label>
              <input value={anoConstrucao} type={"number"} className="form-control" placeholder='Nome Ano Construcao;' name='anoConstrucao' onChange={(e) => onInputChange(e)} />
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Coordenacao</label>
              <input value={coordenacao} type={"text"} className="form-control" placeholder='Nome coordenacao' name='coordenacao' onChange={(e) => onInputChange(e)} />
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> gerencia</label>
              <input value={gerencia} type={"text"} className="form-control" placeholder='Nome gerencia' name='gerencia' onChange={(e) => onInputChange(e)} />
            </div>


            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> diretoria</label>
              <input value={diretoria} type={"text"} className="form-control" placeholder='Nome diretoria' name='diretoria' onChange={(e) => onInputChange(e)} />
            </div>


            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> outorga</label>
              <input value={outorga} type={"text"} className="form-control" placeholder='Nome outorga' name='outorga' onChange={(e) => onInputChange(e)} />
            </div>


            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> titularidade</label>
              <input value={titularidade} type={"text"} className="form-control" placeholder='Nome titularidade' name='titularidade' onChange={(e) => onInputChange(e)} />
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