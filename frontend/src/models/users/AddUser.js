import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';



export default function AddUser() {

  let navigate = useNavigate();

  const [user, setUser] = useState({
    login: "",
    senha: ""
  })

  const { login, senha} = user

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value })
  };


  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/usuarios", user)
    navigate("/")
    
  };

  return (
    <div className='conteiner'>
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4"> Register User</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor='Login' className='form-label'>
                Login
              </label>
              <input
                type="text"
                className="form-control"
                placeholder='Enter your login'
                name='login'
                value={login}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor='Senha' className='form-label'>
                Senha
              </label>
              <input
                type="password"
                className="form-control"
                placeholder='Enter your senha'
                name='senha'
                value={senha}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-success">
              OK
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  )
}
