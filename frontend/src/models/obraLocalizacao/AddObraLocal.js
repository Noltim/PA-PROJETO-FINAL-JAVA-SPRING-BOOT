import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddObraLocal() {
  const [obraLocal, setObrasLocal] = useState({
    cidade: "",
    estado: "",
    latitude: "",
    longitude: "",
    obraId: ""
  })

  const { cidade, estado, latitude, longitude , obraId} = obraLocal;
  
  const [obras, setObras] = useState([]);

  let navigate = useNavigate()

  const onInputChange = (e) => {
    setObrasLocal({ ...obraLocal, [e.target.name]: e.target.value })
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    console.log(obraLocal)
    obraLocal.obraId = {id:obraId};
    console.log(obraLocal)
    let token = localStorage.getItem("user")
    await axios.post(`http://localhost:8080/api/obralocal`, obraLocal, { headers: { "Authorization": token } })
    navigate("/");
  }

  useEffect(() => {
    loadObras();
  }, []);

  const loadObras = async () => {
    let token = localStorage.getItem("user")
    const result = await axios.get(`http://localhost:8080/api/obras`, { headers: { "Authorization": token } })
    console.log(result.data);
    setObras(result.data);
  };

  return (
    <div className='conteiner'>
      <div className='row'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2'>
          <h2 className='text-center m-4'>Registro Obras Local</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> Cidade</label>
              <input value={cidade} type={"text"} className="form-control" placeholder='cidade' name='cidade' onChange={(e) => onInputChange(e)} />
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'>Estado</label>
              <input value={estado} type={"text"} className="form-control" placeholder='estado' name='estado' onChange={(e) => onInputChange(e)} />
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> latitude</label>
              <input value={latitude} type={"text"} className="form-control" placeholder='latitude' name='latitude' onChange={(e) => onInputChange(e)} />
            </div>

            <div className='mb-3'>
              <label htmlFor='Name' className='form-label'> longitude</label>
              <input value={longitude} type={"text"} className="form-control" placeholder='longitude' name='longitude' onChange={(e) => onInputChange(e)} />
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