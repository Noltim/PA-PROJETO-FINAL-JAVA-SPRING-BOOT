import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddUser from './models/users/AddUser';
import AddObra from './models/obras/AddObra';
import ViewObra from './models/obras/ViewObra';
import EditObra from './models/obras/EditObra';
import AddObraLocal from './models/obraLocalizacao/AddObraLocal';
import ViewObraLocal from './models/obraLocalizacao/ViewObraLocal';
import EditObraLocal from './models/obraLocalizacao/EditObraLocal';
import AddObraDetalhes from './models/obraDetalhesTecnicos/AddObraDetalhes';
import ViewObraDetalhes from './models/obraDetalhesTecnicos/ViewObraDetalhes';
import EditObraDetalhes from './models/obraDetalhesTecnicos/EditObraDetalhes';
import AddObraInspecao from './models/obraInspecao/AddObraInspecao';
import ViewObraInspecao from './models/obraInspecao/ViewObraInspecao';
import EditObraInspecao from './models/obraInspecao/EditObraInspecao';
import AddInspecao from './models/Inspecao/AddInspecao';
import ViewInspecao from './models/Inspecao/ViewInspecao';
import EditInspecao from './models/Inspecao/EditInspecao';
import Login from './pages/login';
import ViewObraId from './models/obras/ViewObraId';


function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/login" element={<Login />} />

          <Route exact path="/" element={<Home />} />
          
          <Route exact path="/adduser" element={<AddUser />} />



          <Route exact path="/addobra" element={<AddObra />} />
          <Route exact path="/editobra" element={<EditObra />} />
          <Route exact path="/viewobra" element={<ViewObra />} />
          <Route exact path="/viewobraid" element={<ViewObraId />} />


          <Route exact path="/addobralocal" element={<AddObraLocal />} />
          <Route exact path="/viewobralocal" element={<ViewObraLocal />} />
          <Route exact path="/editobralocal" element={<EditObraLocal />} />


          <Route exact path="/addobradetalhes" element={<AddObraDetalhes />} />
          <Route exact path="/viewobradetalhes" element={<ViewObraDetalhes />} />
          <Route exact path="/editobradetalhes" element={<EditObraDetalhes />} />


          <Route exact path="/addobrainspecao" element={<AddObraInspecao />} />
          <Route exact path="/viewobrainspecao" element={<ViewObraInspecao />} />
          <Route exact path="/editobrainspecao" element={<EditObraInspecao />} />


          <Route exact path="/addinspecao" element={<AddInspecao />} />
          <Route exact path="/viewinspecao" element={<ViewInspecao />} />
          <Route exact path="/editinspecao" element={<EditInspecao />} />


        </Routes>
      </Router>

    </div>
  );
}

export default App;
