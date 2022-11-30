import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewObraInspecaoByID() {

    const [obraInpecao, setObraInpecao] = useState({
        frequencia: "",
        mes: "",
        status: "",
        prioridade: "",
        obraId: ""
    })

    const { id } = useParams();

    const loadObra = async () => {
        let token = localStorage.getItem("user")
        const result = await axios.get(`http://localhost:8080/api/obrainspecoes/${id}`, { headers: { "Authorization": token } })
        console.log(result.data)
        setObraInpecao(result.data);
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
                            Details of obra id: {obraInpecao.id}
                            <ul className='list-group list-group-item'>
                                <li className='list-group-item'>
                                    <b>Obra: </b>
                                    {obraInpecao.obraId.nome}
                                </li>
                                <li className='list-group-item'>
                                    <b>frequencia: </b>
                                    {obraInpecao.frequencia}
                                </li>
                                <li className='list-group-item'>
                                    <b>status: </b>
                                    {obraInpecao.status}
                                </li>
                                <li className='list-group-item'>
                                    <b>mes: </b>
                                    {obraInpecao.mes}
                                </li>
                                <li className='list-group-item'>
                                    <b>prioridade: </b>
                                    {obraInpecao.prioridade}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to="/viewobrainspecao">Voltar</Link>
                </div>
            </div>
        </div>
    )
}