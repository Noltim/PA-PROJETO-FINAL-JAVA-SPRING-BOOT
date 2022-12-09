import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewDetalhesObrasById() {

    const [obraDetalhes, setObraDetalhes] = useState({
        tipo: "",
        risco: "",
        obraId: ""
    })

    const { id } = useParams();

    const loadObra = async () => {
        let token = localStorage.getItem("user")
        const result = await axios.get(`http://localhost:8080/api/detalhesobra/${id}`, { headers: { "Authorization": token } })
        console.log(result.data)
        setObraDetalhes(result.data);
    }

    useEffect(() => {
        loadObra()
    }, []);


    return (
        <div className='conteiner text-light'>
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <div className="card">
                        <div className='card-header'>
                            Detalhes da obra do id: {obraDetalhes.id}
                            <ul className='list-group list-group-item'>
                                <li className='list-group-item'>
                                    <b>Obra: </b>
                                    {obraDetalhes.obraId.nome}
                                </li>
                                <li className='list-group-item'>
                                    <b>tipo: </b>
                                    {obraDetalhes.tipo}
                                </li>
                                <li className='list-group-item'>
                                    <b>risco: </b>
                                    {obraDetalhes.risco}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to="/viewobradetalhes">Voltar</Link>
                </div>
            </div>
        </div>
    )
}