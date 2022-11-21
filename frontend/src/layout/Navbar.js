import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
    return (

        <div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <div className="container-fluid"  >
                    <a className="navbar-brand " href="/">
                        Projeto Triplex
                    </a>
                    <button class="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation" >
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            {/* <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/adduser">Cadastrar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/login">Login</a>
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
                            <Link className="btn btn-dark mx-1" to="/adduser">
                                Cadastrar
                            </Link>
                            <Link className="btn btn-dark mx-1" to="/login">
                                Login
                            </Link>
                        </div>
                    </div>
                </div>

            </nav>

        </div>


    )
}
