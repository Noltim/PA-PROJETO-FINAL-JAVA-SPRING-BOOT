import React, { useState, useEffect } from "react";
import { Link, useNavigate } from 'react-router-dom';
import axios from "axios";
import { axiosInstance } from "../api/api"

const App = () => {
    const [login, setLogin] = useState("");
    const [senha, setSenha] = useState("");
    const [user, setUser] = useState();


    let navigate = useNavigate();



    useEffect(() => {
        const loggedInUser = localStorage.getItem(user);
        if (loggedInUser) {
            const foundUser = JSON.parse(loggedInUser);
            setUser(foundUser);
        }
    }, []);

    // logout the user
    const handleLogout = () => {
        localStorage.clear();
        navigate("/")

    };



    const handleSubmit = async e => {
        e.preventDefault();
        const user = { login, senha };
        // enviar o nome de usuário e a senha ao servidor
        const response = await axios.post(
            "http://localhost:8080/api/usuarios/auth",
            user
        );
        // definir o state do usuário
        setUser(response.data)
        // armazenar o usuário em localStorage
        let token = "Bearer " + response.data.token;
        localStorage.setItem('user', token)
        console.log(response.data)
        // depois de consultar se estar vindo deletar daqui


        console.log(token);

        axiosInstance.interceptors.request.use((config) => {
            config.headers.token = token;
        })

    };




    // Se houver um usuário, mostre a mensagem abaixo
    if (user) {
        return (
            <div>
                {user.name} is loggged in
                <button onClick={handleLogout} className="btn btn-outline-danger mx-2" to="/">logout</button>
            </div>
        );
    }

    // Se não houver um usuário, mostre o formulário de login
    return (
        <div class="container">
            <div class="container2">
                <h2> Authentication</h2>
                <form onSubmit={handleSubmit}>
                    <div class="login-usuario">
                        <label htmlFor="login">Login do usuário: </label>
                        <input type="text" name='login' value={login} placeholder="insira um nome de usuário" onChange={({ target }) => setLogin(target.value)} />
                    </div>

                    <div class="senha-usuario">
                        <label htmlFor="senha">Senha: </label>
                        <input type="password" name='senha' value={senha} placeholder="insira uma senha" onChange={({ target }) => setSenha(target.value)} />
                    </div>
                    <div class="alinha-botao">
                        <button type="submit" class="login">Login</button>
                        <Link to="/" class="cancel">
                            Cancel
                        </Link>
                    </div>
                </form>
            </div>
        </div>
        
    );
};

export default App;