import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';



export default function AddUser() {

  let navigate = useNavigate();

  const [user, setUser] = useState({
    login: "",
    senha: ""
  })

  const { login, senha } = user

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value })
  };


  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/usuarios", user)
    navigate("/login")

  };

  return (
    <div class="container-login">
      <div class="container2">
        <h2 > Register User</h2>
        <form onSubmit={(e) => onSubmit(e)}>
          <div class="login-usuario">
            <label htmlFor='Login'>
              Login
            </label>
            <input
              type="text"
              placeholder='Enter your login'
              name='login'
              value={login}
              onChange={(e) => onInputChange(e)}
            />
          </div>
          <div  class="senha-usuario">
            <label htmlFor='Senha'>
              Senha
            </label>
            <input
              type="password"
              placeholder='Enter your senha'
              name='senha'
              value={senha}
              onChange={(e) => onInputChange(e)}
            />
          </div>
          <div class="alinha-botao">
            <button type="submit" class="login" >
              OK
            </button>
            <Link to="/login" class="cancel">
              Cancel
            </Link>
          </div>
        </form>
      </div>
    </div>
  )
}
