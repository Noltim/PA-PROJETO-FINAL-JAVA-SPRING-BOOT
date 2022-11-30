import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';

export default function AddInspecao() {
  const [obraInspecao, setObraInspecao] = useState({
    data: "",
    observacoes: "",
    obraInspecaoId: ""
  })

  const { data, observacoes , obraInspecaoId} = obraInspecao;
  
  let navigate = useNavigate()
  let token = localStorage.getItem("user")


  const onInputChange = (e) => {
    setObraInspecao({ ...obraInspecao, [e.target.name]: e.target.value })
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    console.log(obraInspecao)
    obraInspecao.obraInspecaoId = {id:obraInspecaoId};
    console.log(obraInspecao)
    await axios.post(`http://localhost:8080/api/inspecoes`, obraInspecao, { headers: { "Authorization": token } })
    navigate("/");
  }

  const [obras, setObras] = useState([]);

  useEffect(() => {
    loadObras();
  }, []);

  const loadObras = async () => {
    let token = localStorage.getItem("user")
    const result = await axios.get(`http://localhost:8080/api/obrainspecoes`, { headers: { "Authorization": token } })
    console.log(result.data);
    setObras(result.data);
  };

  return (
    <div className='conteiner text-light'>
      <div className='row'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2'>
          <h2 className='text-center m-4'>Registro Obras Local</h2>
          <form onSubmit={(e) => onSubmit(e)}>       

            <div className='mb-3'>
            <label htmlFor='Name' className='form-label'> Obras</label>
              <select  onChange={(e) => onInputChange(e)} className="form-control" name='obraInspecaoId' value={obraInspecaoId.id} >
                <option value="0"> -- Seleciona a obra-- </option>
                {
                  obras.map((obra, index) => (
                    <option key={obra.id} value={obra.id}>{obra.id} | {obra.frequencia}</option>
                  ))
                }
              </select>
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Data</label>
              <input value={data} type={"text"} className="form-control" placeholder='data' name='data' onChange={(e) => onInputChange(e)} />
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'>observacoes</label>
              <input value={observacoes} type={"text"} className="form-control" placeholder='observacoes' name='observacoes' onChange={(e) => onInputChange(e)} />
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