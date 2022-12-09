import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function Navbar(props) {

    const [token, setToken] = useState()
    let navigate = useNavigate();

    useEffect(() => {
        setToken(localStorage.getItem('user'))
        console.log(token)
        if(props.token)
            setToken(props.token)
    }, [token])

    // logout the user
    const handleLogout = () => {
        console.log("saiu")
        localStorage.clear();
        setToken(null)
        navigate("/login")
    };

    return (

        <div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <div className="container-fluid"  >
                    <a className="navbar-brand" href="/">
                        Projeto Triplex
                    </a>
                    <button className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation" >
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse"
                        id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            {/* {/* <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/adduser">Cadastrar</a>
                            </li> */}

                            {/* <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/viewobraid">Obra ID</a>
                            </li> */}

                        </ul>


                        <button
                            className="navbar-toggler"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent"
                            aria-expanded="false"
                            aria-label="Toggle navigation"
                        >
                            <span className="navbar-toggler-icon"></span>
                        </button>

                        <div>
                            {token === null &&
                                <Link className="btn btn-dark mx-1" to="/adduser">
                                    Cadastrar
                                </Link>}
                            {token === null &&
                                <Link className="btn btn-dark mx-1" to="/login">
                                    Login
                                </Link>}

                            {token !== null &&
                                <button className="btn btn-dark mx-1" onClick={handleLogout}>
                                    Sair
                                </button>}
                        </div>
                    </div>
                </div>

            </nav>

        </div>


    )
}
